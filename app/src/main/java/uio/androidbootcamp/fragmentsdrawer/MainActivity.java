package uio.androidbootcamp.fragmentsdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static uio.androidbootcamp.fragmentsdrawer.R.id.nav_pokemon;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PokemonFragment.OnPokemonFragmentInteractionListener,
        StarWarsFragment.OnStarWarsFragmentInteractionListener {

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = toolbarSetup();
        drawerSetup(toolbar);
        navigationViewSetup();

        PokemonFragment pokemonFragment = PokemonFragment.newInstance();
        showFragment(pokemonFragment, null);
    }

    private void showFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        if (tag != null) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    private void navigationViewSetup() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void drawerSetup(Toolbar toolbar) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private Toolbar toolbarSetup() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    public void setSelectedDrawerItem(int item) {
        navigationView.setCheckedItem(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(this, R.string.action_settings, Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_pokemon) {
            Toast.makeText(this, R.string.pokemon, Toast.LENGTH_LONG).show();
            PokemonFragment pokemonFragment = PokemonFragment.newInstance();
            showFragment(pokemonFragment, "pokemon");
        } else if (id == R.id.nav_star_wars) {
            Toast.makeText(this, R.string.star_wars, Toast.LENGTH_LONG).show();
            StarWarsFragment starWarsFragment = StarWarsFragment.newInstance();
            showFragment(starWarsFragment, "starWars");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPokemonClicked(String pokemon) {
        Toast.makeText(this, pokemon, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDroidClicked(String droid) {
        Toast.makeText(this, droid, Toast.LENGTH_LONG).show();
        DroidDetailsFragment droidDetailsFragment = DroidDetailsFragment.newInstance(droid);
        showFragment(droidDetailsFragment, "droid");
    }
}
