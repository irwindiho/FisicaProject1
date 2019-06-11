package com.apps.irdhilmc.fisicaproyect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.apps.irdhilmc.fisicaproyect.adapters.FormulasAdapter;
import com.apps.irdhilmc.fisicaproyect.entiites.Formula;
import com.apps.irdhilmc.fisicaproyect.temas.Mru;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FormulasAdapter.OnItemFormulaClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.txtVelocidad)
    TextInputEditText txtVelocidad;
    @BindView(R.id.contentVelocidad)
    TextInputLayout contentVelocidad;
    @BindView(R.id.txtDistancia)
    TextInputEditText txtDistancia;
    @BindView(R.id.contentDistancia)
    TextInputLayout contentDistancia;
    @BindView(R.id.txtTiempo)
    TextInputEditText txtTiempo;
    @BindView(R.id.contentTiempo)
    TextInputLayout contentTiempo;

    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    int operacion = 0;


    @BindView(R.id.txtResultado)
    TextInputEditText txtResultado;
    @BindView(R.id.contentResultado)
    TextInputLayout contentResultado;
    @BindView(R.id.content_mru)
    CardView contentMru;
    @BindView(R.id.title_mruv)
    TextView titleMruv;
    @BindView(R.id.content_mruv)
    CardView contentMruv;
    @BindView(R.id.btnCalcular)
    FloatingActionButton btnCalcular;
    @BindView(R.id.btnLimpiar)
    FloatingActionButton btnLimpiar;
    @BindView(R.id.rvListaFormula)
    RecyclerView rvListaFormula;
    @BindView(R.id.txtVelocidadInicial)
    TextInputEditText txtVelocidadInicial;
    @BindView(R.id.contentVelocidadInicial)
    TextInputLayout contentVelocidadInicial;
    @BindView(R.id.txtDistanciaMruv)
    TextInputEditText txtDistanciaMruv;
    @BindView(R.id.contentDistanciaMruv)
    TextInputLayout contentDistanciaMruv;


    FormulasAdapter formulasAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setOtherSeetingss();

    }

    private void setupRVFormulas(int tipoFormula) {
        Log.d(TAG, "setupRVFormulas: ");

        List<Formula> formulaList = new ArrayList<>();
        switch (tipoFormula) {

            case 1:
                formulaList.addAll(Formula.LlenarListaMRUFormulas());
                break;
            case 2:
//                formulaList.addAll(Formula.LlenarListaMRUVFormulas());
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

        }

        if (formulasAdapter == null) {
            formulasAdapter = new FormulasAdapter(formulaList, this);
            rvListaFormula.setLayoutManager(new LinearLayoutManager(this));
            rvListaFormula.setAdapter(formulasAdapter);
        } else {
            rvListaFormula.setAdapter(formulasAdapter);
        }
    }


    private void setOtherSeetingss() {

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        limpiarImputs();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_option_mru) {
            setupRVFormulas(1);


        } else if (id == R.id.nav_option_mruv) {
            setupRVFormulas(2);
//            showLayoutOpcion(false, 2, contentMru);
//            showLayoutOpcion(true, 2, contentMruv);

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showLayoutOpcion(boolean showLayout, int operacionSelected, int codigoFormula, CardView content) {
        if (showLayout) {
            content.setVisibility(View.VISIBLE);
        } else {
            content.setVisibility(View.GONE);
        }
        operacion = operacionSelected;
        switch (codigoFormula) {
            case 1:
                ocultarImput(contentDistancia);
                verImputs(contentVelocidad, contentTiempo);
                break;
            case 2:
                ocultarImput(contentTiempo);
                verImputs(contentDistancia, contentVelocidad);

                break;
            case 3:
                ocultarImput(contentVelocidad);
                verImputs(contentDistancia, contentTiempo);

                break;
        }

    }

    private void verImputs(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setVisibility(View.VISIBLE);
        textInputLayout2.setVisibility(View.VISIBLE);

    }

    private void ocultarImput(TextInputLayout inputLayout) {
        inputLayout.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnCalcular)
    public void onViewClicked() {
        errors = 0;
        switch (operacion) {
            case 1:
                calcularMRU();
                break;
            case 2:
                calcularMRUV();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

    }

    private void calcularMRUV() {

    }


    private void calcularMRU() {

        double tiempo = 0;
        double distancia = 0;
        double velocidad = 0;

        validarImput(txtVelocidad);
        validarImput(txtDistancia);
        validarImput(txtTiempo);

        if (errors == 0) {
            velocidad = Double.parseDouble(txtVelocidad.getText().toString());
            distancia = Double.parseDouble(txtDistancia.getText().toString());
            tiempo = Double.parseDouble(txtTiempo.getText().toString());
            if (distancia <= 0) {
                showResultado(Mru.getInstance().calcularDistancia(velocidad, tiempo), "La Distancia es:", "Metros");
            } else {

            }
            if (velocidad <= 0) {
                showResultado(Mru.getInstance().calcularVelocidad(distancia, tiempo), "La Velocidad es:", "Metros/segundos");
            } else if (tiempo <= 0) {
                showResultado(Mru.getInstance().calcularTiempo(distancia, velocidad), "El Tiempo es:", "Segundos");
            }
        }

    }

    private void showResultado(double result, String textHint, String magnitud) {
        contentResultado.setVisibility(View.VISIBLE);
        contentResultado.setHint(textHint);
        txtResultado.setText(String.format("%s %s", String.valueOf(result), magnitud));
    }

    int errors = 0;

    private void validarImput(TextInputEditText inputEditText) {
        if (inputEditText.getText().toString().equals("")) {
            errors++;
            inputEditText.setError("Ingrese Este valor");
        }
    }


    @OnClick(R.id.btnLimpiar)
    public void onViewLimpiarClickedLimpiar() {
        limpiarImputs();
    }

    private void limpiarImputs() {
        txtDistancia.setText("0");
        txtTiempo.setText("0");
        txtVelocidad.setText("0");
        hideResultado();
    }

    private void hideResultado() {
        contentResultado.setVisibility(View.GONE);
        txtResultado.setText("0");

    }

    @Override
    public void onClickItem(Formula formula) {
        Log.d(TAG, "onClickItem: ");
        toolbar.setTitle("Movimiento Rectilineó Uniforme");
        showLayoutOpcion(true, formula.getPositionFormula(), formula.getCodigoFormula(), contentMru);
        showLayoutOpcion(false, formula.getPositionFormula(), formula.getCodigoFormula(), contentMruv);
    }
}
