package com.jeremy.ppe_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class FormationListActivity extends ActionBarActivity
        implements FormationListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (findViewById(R.id.formation_detail_container) != null) {
            mTwoPane = true;

            ((FormationListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.formation_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(FormationDetailFragment.ARG_ITEM_ID, id);
            FormationDetailFragment fragment = new FormationDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.formation_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, FormationDetailActivity.class);
            detailIntent.putExtra(FormationDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, FormationSearchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
