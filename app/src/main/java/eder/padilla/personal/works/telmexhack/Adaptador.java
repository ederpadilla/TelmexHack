package eder.padilla.personal.works.telmexhack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador
        extends RecyclerView.Adapter<Adaptador.TitularesViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Amigos> amigosArrayList;
    Context context;

    public Adaptador(ArrayList<Amigos> datos, Context context) {
        this.amigosArrayList = datos;
        this.context = context;
    }

    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem, viewGroup, false);
        itemView.setOnClickListener(this);
        TitularesViewHolder tvh = new TitularesViewHolder(itemView);
        return tvh;
    }

    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Amigos item = amigosArrayList.get(pos);

        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return amigosArrayList.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }
    public  class TitularesViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtNombre;

        public TitularesViewHolder(View itemView) {
            super(itemView);
            txtNombre = (TextView) itemView.findViewById(R.id.nombre);
        }
        public void bindTitular(Amigos amigos) {
            txtNombre.setText(amigos.getNombre());
        }
    }
}

