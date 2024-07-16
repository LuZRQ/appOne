package com.example.recycleviews;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviews.adapter.ListaAdapterCliente;
import com.example.recycleviews.model.Cliente;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaClientes;
    private ArrayList<Cliente> clientes;
    private EditText Trs; // Definir EditText para Razón Social
    private EditText Tn; // Definir EditText para NIT
    private LinearLayout contenedorAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CargarR();
        CargarRecycleView();
    }

    // Método para cargar los elementos de la interfaz
    public void CargarR() {
        listaClientes = findViewById(R.id.recListaPersona);
        Trs = findViewById(R.id.editTextRazonSocial);
        Tn = findViewById(R.id.editTextNit);
        contenedorAgregar = findViewById(R.id.contenedorAgregar);
    }

    // Método para agregar un cliente
    public void agregarCliente(View view) {
        String razonSocial = Trs.getText().toString();
        int nit = Integer.parseInt(Tn.getText().toString());
        Cliente nuevoCliente = new Cliente(razonSocial, nit);
        clientes.add(nuevoCliente);
        listaClientes.getAdapter().notifyItemInserted(clientes.size() - 1); // Notificar al adaptador que se ha agregado un nuevo elemento
        Trs.setText("");
        Tn.setText("");
        // Ocultar el contenedor de agregar cliente después de agregar el cliente
        contenedorAgregar.setVisibility(View.GONE);
    }

    // Método para cargar el RecyclerView
    public void CargarRecycleView() {
        listaClientes.setLayoutManager(new LinearLayoutManager(this));
        clientes = new ArrayList<>();
        clientes.add(new Cliente("MAMANI", 12345666));
        clientes.add(new Cliente("PEREZ", 14588759));
        ListaAdapterCliente listaAdapterCliente = new ListaAdapterCliente(clientes);
        listaClientes.setAdapter(listaAdapterCliente);
    }

    // Método para mostrar u ocultar el contenedor de agregar cliente
    public void mostrarCamposAgregar(View view) {
        if (contenedorAgregar.getVisibility() == View.VISIBLE) {
            contenedorAgregar.setVisibility(View.GONE); // Ocultar el contenedor si ya está visible
        } else {
            contenedorAgregar.setVisibility(View.VISIBLE); // Mostrar el contenedor si está oculto
        }
    }
}