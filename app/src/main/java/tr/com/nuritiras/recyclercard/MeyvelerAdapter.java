package tr.com.nuritiras.recyclercard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MeyvelerAdapter extends RecyclerView.Adapter<MeyvelerAdapter.MeyvelerHolder> {
    private ArrayList<Meyveler> meyvelerList;
    private Context context;
    private OnItemClickListener listener;

    public MeyvelerAdapter(ArrayList<Meyveler> meyvelerList, Context context) {
        this.meyvelerList = meyvelerList;
        this.context = context;
    }

    @NonNull
    @Override
    public MeyvelerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.meyveler_item,parent,false);
        return new MeyvelerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeyvelerHolder holder, int position) {
        Meyveler meyveler=meyvelerList.get(position);
        holder.setData(meyveler);
    }

    @Override
    public int getItemCount() {
        return meyvelerList.size();
    }

    class MeyvelerHolder extends RecyclerView.ViewHolder{
        TextView meyveIsmi,meyveKalori;
        ImageView meyveResim;

        public MeyvelerHolder(@NonNull View itemView) {
            super(itemView);
            meyveIsmi=(TextView) itemView.findViewById(R.id.meyveler_item_textViewMeyveIsmi);
            meyveKalori=(TextView) itemView.findViewById(R.id.meyveler_item_textViewMeyveKalori);
            meyveResim=(ImageView) itemView.findViewById(R.id.meyveler_item_imageViewResim);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();

                    if(listener !=null && position != RecyclerView.NO_POSITION)
                        listener.onItemClick(meyvelerList.get(position),position);
                }
            });

        }

        public void setData(Meyveler meyveler){
            this.meyveIsmi.setText(meyveler.getMeyveIsmi());
            this.meyveKalori.setText(String.valueOf(meyveler.getMeyveKalori()));
            this.meyveResim.setBackgroundResource(meyveler.getMeyveResim());
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Meyveler meyveler,int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        this.listener=listener;

    }
}
