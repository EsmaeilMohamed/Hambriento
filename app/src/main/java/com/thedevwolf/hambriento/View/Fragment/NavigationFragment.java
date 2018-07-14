package com.thedevwolf.hambriento.View.Fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;
import com.thedevwolf.hambriento.Callback.NavigationCloseDrawerListener;
import com.thedevwolf.hambriento.Callback.NavigationItemListener;
import com.thedevwolf.hambriento.Model.NavigationMenuModel;
import com.thedevwolf.hambriento.R;
import com.thedevwolf.hambriento.View.Activity.FavoriteActivity;
import com.thedevwolf.hambriento.View.Activity.LoginActivity;
import com.thedevwolf.hambriento.View.Adapter.Recycler.NavigationAdapter;
import com.thedevwolf.hambriento.databinding.FragmentNavigationBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NavigationFragment  extends Fragment {

    FragmentNavigationBinding navigationBinding;
    SweetAlertDialog progressDialog;


    FirebaseAuth mAuth;

    List<NavigationMenuModel> menuModelList;
    NavigationAdapter navigationAdapter;

    //callbacks
    NavigationItemListener itemListener;
    NavigationCloseDrawerListener closeDrawerListener;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        navigationBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_navigation,container,false);




        //initial firebase auth
        mAuth=FirebaseAuth.getInstance();
        //initial item listener
        itemListener=new NavigationItemListener() {
            @Override
            public void onHomeClick() {
                closeDrawerListener.onDrawerClose(true);
            }

            @Override
            public void onFavoriteClick() {
            startActivity(new Intent(getActivity(), FavoriteActivity.class));
            }

            @Override
            public void onLogoutClick() {


                new SweetAlertDialog(Objects.requireNonNull(getActivity()), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText(getString(R.string.exit1))
                        .setContentText(getString(R.string.exit2))
                        .setConfirmText(getString(R.string.exit3))
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(final SweetAlertDialog sDialog) {

                                AuthUI.getInstance()
                                        .signOut(getActivity())
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                sDialog.dismiss();

                                                startActivity(new Intent(getActivity(), LoginActivity.class)
                                                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                                getActivity().finish();


                                            }
                                        });
                            }
                        })

                        .show();



            }
        };

        setMenuData();

        return navigationBinding.getRoot();
    }

    private void setMenuData() {
        //add menu item to adapter data source
        menuModelList=new ArrayList<>();
        menuModelList.add(new NavigationMenuModel(getString(R.string.home),R.drawable.ic_home_24dp));
        menuModelList.add(new NavigationMenuModel(getString(R.string.favorite),R.drawable.ic_favorite_24dp));
        menuModelList.add(new NavigationMenuModel(getString(R.string.logout),R.drawable.exit));


        //initial recycler
        navigationBinding.rvMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        navigationAdapter=new NavigationAdapter(menuModelList,itemListener,getActivity());
        navigationBinding.rvMenu.setAdapter(navigationAdapter);

        //Set user picture and name
        Picasso.get().load(mAuth.getCurrentUser().getPhotoUrl()).placeholder(R.drawable.profile).into(navigationBinding.ivUserPic);
        navigationBinding.tvUserName.setText(mAuth.getCurrentUser().getDisplayName());

    }


    public NavigationCloseDrawerListener getCloseDrawerListener() {
        return closeDrawerListener;
    }
    public void setCloseDrawerListener(NavigationCloseDrawerListener closeDrawerListener) {
        this.closeDrawerListener = closeDrawerListener;
    }
}
