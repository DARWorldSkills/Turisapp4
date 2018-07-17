package com.aprendiz.ragp.quindioturistico4b.models;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.aprendiz.ragp.quindioturistico4b.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterT extends RecyclerView.Adapter<AdapterT.Holder>{
    List<Sitios> sitiosList = new ArrayList<>();
    int item;
    Context context;
    private OnItemClickListener mlistener;
    public  interface OnItemClickListener{
        void itemClick(int position);
    }

    public AdapterT(List<Sitios> sitiosList, int item, Context context) {
        this.sitiosList = sitiosList;
        this.item = item;
        this.context = context;
    }

    public void setMlistener(OnItemClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.connectData(sitiosList.get(position));
    }

    @Override
    public int getItemCount() {
        return sitiosList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imageView = itemView.findViewById(R.id.imgItem);
        TextView txtnombre;
        TextView txtubicacion;
        TextView txtdescripcion;

        public Holder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });
        }

        public void connectData(Sitios sitios){
            switch (item){
                case R.layout.item_lista:
                    txtnombre= itemView.findViewById(R.id.txtNombreLista);
                    txtubicacion= itemView.findViewById(R.id.txtUbicacionLista);
                    txtdescripcion= itemView.findViewById(R.id.txtDescripcionLista);

                    txtnombre.setText(sitios.getNombre());
                    txtubicacion.setText(sitios.getUbicacion());
                    txtdescripcion.setText(sitios.getDescripcionc());
                    break;

                case R.layout.item_grid:
                    txtnombre= itemView.findViewById(R.id.txtNombreGrid);
                    txtubicacion= itemView.findViewById(R.id.txtUbicacionGrid);
                    txtnombre.setText(sitios.getNombre());
                    txtubicacion.setText(sitios.getUbicacion());
                    break;

                case R.layout.item_land:
                    txtnombre= itemView.findViewById(R.id.txtNombreLand);
                    txtnombre.setText(sitios.getNombre());

                    break;
            }

            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inSampleSize=3;
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),sitios.getImagen(),op);
            imageView.setImageBitmap(bitmap);
        }
    }
}
