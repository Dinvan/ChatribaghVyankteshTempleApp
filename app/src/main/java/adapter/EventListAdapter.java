package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ank.chatribaghvyankteshtempleapp.R;

import java.lang.reflect.Array;

/**
 * Created by dbagv_000 on 7/1/2016.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder> {

    private String[] eventList;
    private int[] slipImage;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView slip_image;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.txtEvent);
            slip_image=(ImageView)view.findViewById(R.id.slip_image);

        }
    }


    public EventListAdapter(String[] moviesList,int[] slipImage, Context context) {
        this.eventList = moviesList;
        this.slipImage=slipImage;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_events, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        if(position%2==0) {
           // holder.title.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }
        else
        {
            //holder.title.setTextColor(context.getResources().getColor(R.color.eventTextColor));
        }
        holder.title.setText(eventList[position]);
        holder.slip_image.setImageResource(slipImage[position]);
    }

    @Override
    public int getItemCount() {
        return eventList.length;
    }
}