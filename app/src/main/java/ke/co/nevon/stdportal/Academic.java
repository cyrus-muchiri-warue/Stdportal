package ke.co.nevon.stdportal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Academic extends Fragment {
        TextView regNo;
        SharedPreferences sharedPreferences;
        RecyclerView recyclerView;
        AcademicAdapter academicAdapter;
        ArrayList<AcademicMenuList>menuLists=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuLists.add(new AcademicMenuList("MY PROFILE"));
        menuLists.add(new AcademicMenuList("TIMETABLE"));
        menuLists.add(new AcademicMenuList("EXAM RESULT"));
        menuLists.add(new AcademicMenuList("LECTURERS"));
        menuLists.add(new AcademicMenuList("REGISTER UNITS"));
        menuLists.add(new AcademicMenuList("INTERNAL MEMO"));
        menuLists.add(new AcademicMenuList("ACADEMIC MATERIALS"));

        academicAdapter=new AcademicAdapter(getContext(),menuLists);
    }

    public interface Session{
        public void getSharedPreferences(SharedPreferences sharedPreferences);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.academic_fragment, container, false);
        regNo=view.findViewById(R.id.regno);
        recyclerView=view.findViewById(R.id.Menurecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(academicAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
