package cl.virginio.gomez.frutos.secos.frutossecosapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


import cl.virginio.gomez.frutos.secos.frutossecosapp.R;
import cl.virginio.gomez.frutos.secos.frutossecosapp.dto.ProductoDto;

public class ProductoAdapter extends FirestoreRecyclerAdapter<ProductoDto, ProductoAdapter.ViewHolder> {
   

   Activity activity;
   FragmentManager fm;
   /**
    * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
    * FirestoreRecyclerOptions} for configuration options.
    *
    * @param options
    */
   public ProductoAdapter(@NonNull FirestoreRecyclerOptions<ProductoDto> options, Activity activity, FragmentManager fm) {
      super(options);
      this.activity = activity;
      this.fm = fm;
   }

   @Override
   protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull ProductoDto productoDto) {
      viewHolder.nombre.setText(productoDto.getNombre());
      viewHolder.codigo.setText(productoDto.getCodigo());
      viewHolder.precio.setText(productoDto.getPrecio());
      viewHolder.descripcion.setText(productoDto.getDescripcion());
   }



   @NonNull
   @Override
   public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_view, parent, false);
      return new ViewHolder(v);
   }

   public class ViewHolder extends RecyclerView.ViewHolder {
      TextView nombre, codigo, precio, descripcion;

      public ViewHolder(@NonNull View itemView) {
         super(itemView);

         nombre = itemView.findViewById(R.id.textViewNombre);
         codigo = itemView.findViewById(R.id.textViewCodigo);
         descripcion = itemView.findViewById(R.id.textViewDescripcion);
         precio = itemView.findViewById(R.id.textViewPrecio);
      }
   }
}
