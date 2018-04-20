package com.hitch.startup.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hitch.startup.R;
import com.hitch.startup.fragment.MainFragment;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XWSPH on 19/09/2017.
 */

public class MainActivity extends AppCompatActivity  implements OnMenuItemClickListener, OnMenuItemLongClickListener {

    //menu bar
    private FragmentManager fragmentManager;
    private ContextMenuDialogFragment mMenuDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        initToolbar();
        initMenuFragment();
        addFragment(new MainFragment(), true, R.id.container);

    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();

        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tool_bar_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);

        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
        mMenuDialogFragment.setItemLongClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {
        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject about = new MenuObject("About");
        about.setResource(R.drawable.icn_about);

        MenuObject rate = new MenuObject("Rate Us");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_rate);
        rate.setBitmap(b);

        MenuObject share = new MenuObject("Share");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_share));
        share.setDrawable(bd);

        MenuObject more = new MenuObject("More Apps");
        more.setResource(R.drawable.icn_2);

        MenuObject exit = new MenuObject("Exit");
        exit.setResource(R.drawable.btn_back);

        menuObjects.add(close);
        menuObjects.add(about);
        menuObjects.add(rate);
        menuObjects.add(share);
        menuObjects.add(more);
        menuObjects.add(exit);

        return menuObjects;
    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        /*/mToolbar.setNavigationIcon(R.drawable.btn_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });*/
    }

    protected void addFragment(Fragment fragment, boolean addToBackStack, int containerId) {

        invalidateOptionsMenu();

        String backStackName = fragment.getClass().getName();
        boolean fragmentPopped = fragmentManager.popBackStackImmediate(backStackName, 0);
        if (!fragmentPopped) {

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(containerId, fragment, backStackName)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

            if (addToBackStack)
                transaction.addToBackStack(backStackName);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {
                    mMenuDialogFragment.show(fragmentManager, ContextMenuDialogFragment.TAG);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Do you want to Exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (mMenuDialogFragment != null && mMenuDialogFragment.isAdded()) {
                            mMenuDialogFragment.dismiss();
                        } else {
                            finish();
                        }
                    }
                })
                .setNegativeButton("No", null)
                .show();

    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {

        if (position == 1){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            //Set title for AlertDialog
            builder.setTitle("StartUp  ");

            //Set body message of Dialog
            builder.setMessage("StartUp - Survival is an guide application that" +
                    " is completely based on the USA Military Survival Manual FM 21-76."
                    +"\n and this Manual which is fully working offline (that's important to survive in a case of some extreme situation)\n" +
                    "It contains info on how to make fire, build a shelter, find food, heal and other useful content in a case of emergency.");

            //// Is dismiss when touching outside?
            builder.setCancelable(true);

            //Negative Button
            builder.setNegativeButton("OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Usually, negative use to close Dialog
                            //So, do nothing here, just dismiss it
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
        if (position == 2){
            Toast.makeText(this, "Rate Us " + position, Toast.LENGTH_SHORT).show();
        }
        if (position == 3){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "market://details?id=" + getPackageName());
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        if (position == 4){
            Toast.makeText(this, "More Apps ", Toast.LENGTH_SHORT).show();
        }
        if (position == 5){
            Toast.makeText(this, "Exit" , Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }

    @Override
    public void onMenuItemLongClick(View clickedView, int position) {
        Toast.makeText(this, "Long clicked on position: " + position, Toast.LENGTH_SHORT).show();
    }

}
