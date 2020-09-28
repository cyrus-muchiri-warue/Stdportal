package ke.co.nevon.stdportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FinanceAdapter extends  RecyclerView.Adapter<FinanceAdapter.MyviewHolder> {
    Context context;
    FinanceDetails[] financeDetails;

    public FinanceAdapter(Context context, FinanceDetails[] financeDetails) {
        this.context = context;
        this.financeDetails = financeDetails;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.financerow,parent,false);
        MyviewHolder holder=new MyviewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        FinanceDetails details=financeDetails[position];
        holder.reg.setText("REGISTRATION NUMBER :"+details.getReg());
        holder.amountBilled.setText("AMOUNT BILLED :"+details.getAmountBilled());
        holder.amountpaid.setText("AMOUNT PAID :"+details.getAmountpaid());
        holder.balance.setText("BALANCE :"+details.getBalance());
        holder.statementcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),"downloading",Toast.LENGTH_LONG).show();

            }
        });
        holder.appealcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(),"procee to make appeal",Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return financeDetails.length;
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder{

        TextView reg,amountBilled,amountpaid,balance;
        Button statement,appeal;
        CardView detail,statementcard,appealcard;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            reg=itemView.findViewById(R.id.regno);
            amountBilled=itemView.findViewById(R.id.amountbilled);
            amountpaid=itemView.findViewById(R.id.amoutpaid);
            balance=itemView.findViewById(R.id.balance);
            statement=itemView.findViewById(R.id.statement);
            appeal=itemView.findViewById(R.id.appeal);
            detail=itemView.findViewById(R.id.detail);
            statementcard=itemView.findViewById(R.id.statementcard);
            appealcard=itemView.findViewById(R.id.appealcard);

        }
    }
}
