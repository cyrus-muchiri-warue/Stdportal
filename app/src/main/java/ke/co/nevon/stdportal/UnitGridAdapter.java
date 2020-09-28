package ke.co.nevon.stdportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import ke.co.nevon.stdportal.UnitDetails;

import androidx.annotation.NonNull;

public class UnitGridAdapter extends ArrayAdapter<UnitDetails> {
    Context context;
    ArrayList<UnitDetails> unitDetails;
    LayoutInflater layoutInflater;


    public UnitGridAdapter(@NonNull Context context,  @NonNull ArrayList<UnitDetails> unitDetails) {
        super(context, R.layout.unitrow,unitDetails);
        this.context=context;
        this.unitDetails=unitDetails;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        layoutInflater=(LayoutInflater)context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        ) ;
        View view=layoutInflater.inflate(R.layout.unitrow,null,true);
        TextView unitname=view.findViewById(R.id.unitName);
        TextView unicode=view.findViewById(R.id.unitcode);
        ToggleButton status=view.findViewById(R.id.togglebotton);
        unitname.setText(unitDetails.get(position).getUnitname());
        unicode.setText(unitDetails.get(position).getUnitcode());
        status.setText(unitDetails.get(position).getStatus());
        return  view;
    }
}
