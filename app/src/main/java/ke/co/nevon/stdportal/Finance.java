package ke.co.nevon.stdportal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Finance extends Fragment {
    public Finance() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.financerecycler, container, false);
        FinanceDetails[] financeDetails=new FinanceDetails[]{
                new FinanceDetails("ct201/0014/16","133000","100000","33000")
        };
        RecyclerView  recyclerView=view.findViewById(R.id.recyclerview);
        FinanceAdapter financeAdapter=new FinanceAdapter(getContext(),financeDetails);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(financeAdapter);



        return view;
    }
}
