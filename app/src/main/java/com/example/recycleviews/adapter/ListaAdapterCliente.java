package com.example.recycleviews.adapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviews.R;
import com.example.recycleviews.model.Cliente;

import java.util.ArrayList;
public class ListaAdapterCliente  extends RecyclerView.Adapter<ListaAdapterCliente.ListaClienteViewHolder> {

    ArrayList<Cliente> clientes;

    public ListaAdapterCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    //la conexion con id de nuestro layout
    @NonNull
    @Override
    public ListaAdapterCliente.ListaClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_cliente,null,false);
        return new ListaClienteViewHolder(view);
    }
    //id, identificadores de la clase R, pasos de parametros
    @Override
    public void onBindViewHolder(@NonNull ListaAdapterCliente.ListaClienteViewHolder holder, int position) {
        //llamar lista Clientes;
        holder.txtR.setText(clientes.get(position).getRazonSocial());
        holder.txtN.setText(String.valueOf(clientes.get(position).getNit()));
    }

    //el tamano de la lista
    @Override
    public int getItemCount() {
        return clientes.size();
    }


    //vamos a colocar la puente entre clase R y xml
    public class ListaClienteViewHolder extends RecyclerView.ViewHolder {
        TextView txtR, txtN;
        public ListaClienteViewHolder(@NonNull View itemView) {
            super(itemView);
            txtR = itemView.findViewById(R.id.txtRazon);
            txtN = itemView.findViewById(R.id.txtNit);
        }
    }
}
