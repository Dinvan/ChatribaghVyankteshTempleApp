package fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ank.chatribaghvyankteshtempleapp.R;

import java.util.ArrayList;

import models.VratModel;

public class VratFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TableLayout tableLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    protected Typeface mTfLight;
    public VratFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static VratFragment newInstance(String param1, String param2) {
        VratFragment fragment = new VratFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_event, container, false);

        tableLayout = (TableLayout) view.findViewById(R.id.tableLayout);
        mTfLight = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Light.ttf");
        createVratModelList();
        createEvent();
        return  view;

    }
    ArrayList<VratModel> list=new ArrayList<>();
    public void createVratModelList()
    {
        list=new ArrayList<>();
        VratModel vratModel=new VratModel();
        vratModel.setVratName("मार्गशीर्षा");
        vratModel.setVratTithi("११ सोमवार");
        vratModel.setVratDate("०७-१२- २०१५");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("पौष");
        vratModel.setVratTithi("१२ बुधवार");
        vratModel.setVratDate("०६-०१- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("माघ");
        vratModel.setVratTithi("११ गुरुवार");
        vratModel.setVratDate("०४-०२- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("फाल्गुन");
        vratModel.setVratTithi("११ शनिवार");
        vratModel.setVratDate("०५-०३- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("चैत्र");
        vratModel.setVratTithi("१२ सोमवार");
        vratModel.setVratDate("०४-०४- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("वैशाख");
        vratModel.setVratTithi("११ मंगलवार");
        vratModel.setVratDate("०६-०५- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("ज्येष्ठ");
        vratModel.setVratTithi("११ बुधवार");
        vratModel.setVratDate("०१-०६- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("अषाढ़");
        vratModel.setVratTithi("१२ शुक्रवार");
        vratModel.setVratDate("०१-०७- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("सावन");
        vratModel.setVratTithi("११ शनिवार");
        vratModel.setVratDate("३०-०७- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("भाद्रपद");
        vratModel.setVratTithi("११ रविवार");
        vratModel.setVratDate("२८-०८- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("आश्विन");
        vratModel.setVratTithi("११ सोमवार");
        vratModel.setVratDate("२६-०९- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("कार्तिक");
        vratModel.setVratTithi("११ बुधवार");
        vratModel.setVratDate("२६-१०- २०१६");
        list.add(vratModel);
        //-----------------------------------------

        vratModel=new VratModel();
        vratModel.setVratName("कार्तिक");
        vratModel.setVratTithi("११ रविवार");
        vratModel.setVratDate("२२-११- २०१५");
        list.add(vratModel);




         vratModel=new VratModel();
        vratModel.setVratName("मार्गशीर्षा");
        vratModel.setVratTithi("११ सोमवार");
        vratModel.setVratDate("२१-१२- २०१५");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("पौष");
        vratModel.setVratTithi("११ बुधवार");
        vratModel.setVratDate("२०-०१- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("माघ");
        vratModel.setVratTithi("११ गुरुवार");
        vratModel.setVratDate("१८-०२- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("फाल्गुन");
        vratModel.setVratTithi("११ शनिवार");
        vratModel.setVratDate("१९-०३- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("चैत्र");
        vratModel.setVratTithi("११ रविवार");
        vratModel.setVratDate("१७-०४- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("वैशाख");
        vratModel.setVratTithi("११ मंगलवार");
        vratModel.setVratDate("१७-०५- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("ज्येष्ठ");
        vratModel.setVratTithi("११ गुरुवार");
        vratModel.setVratDate("१६-०६- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("अषाढ़");
        vratModel.setVratTithi("११ शुक्रवार");
        vratModel.setVratDate("१५-०७- २०१६");
        list.add(vratModel);


        vratModel=new VratModel();
        vratModel.setVratName("सावन");
        vratModel.setVratTithi("११ रविवार");
        vratModel.setVratDate("१४-०८- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("भाद्रपद");
        vratModel.setVratTithi("११ मंगलवार");
        vratModel.setVratDate("१३-०९- २०१६");
        list.add(vratModel);



        vratModel=new VratModel();
        vratModel.setVratName("आश्विन");
        vratModel.setVratTithi("११ बुधवार");
        vratModel.setVratDate("१२-१०- २०१६");
        list.add(vratModel);


    }


    private TableLayout createEvent() {
        // tableLayout.setBackgroundColor(Color.BLACK);
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,60);
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        String[] headers = {"क्र.","मास","कृष्णपक्ष", "दिनांक"};
        TableRow tableRowHeader = new TableRow(getActivity());
        for (int c = 0; c < headers.length; c++) {
            if (c == 1) {
                addHeaderRow(tableRowHeader, headers[c], Color.parseColor("#DFA7A6"));
            } else {
                if (c == 2) {
                    addHeaderRow(tableRowHeader, headers[c],Color.parseColor("#DFA7A6"));
                } else {
                    addHeaderRow(tableRowHeader, headers[c], Color.parseColor("#DFA7A6"));
                }

            }

        }
        tableRowHeader.setLayoutParams(tableRowParams);

        tableLayout.addView(tableRowHeader);
        for (int dataListIndex = 0; dataListIndex < list.size(); dataListIndex++) {
            VratModel vratModel=list.get(dataListIndex);
            TableRow tableRow = new TableRow(getActivity());
            addHeader(tableRow, dataListIndex+1 + "",Color.parseColor("#DFA7A6"));
            int color;
            if(dataListIndex%2==1)
            {
                color=Color.parseColor("#EFD3D3");
            }else {
                color=Color.parseColor("#DFA7A6");
            }
            addHeader(tableRow, vratModel.getVratName(),color);
            addHeader(tableRow, vratModel.getVratTithi() + "",color);
            addHeader(tableRow,vratModel.getVratDate() + "", color);




            tableLayout.addView(tableRow);

            if(dataListIndex==11)
            {
                String[] headersNew = {"","मास","शुक्लपक्ष", "दिनांक"};
                TableRow tableRowHeaderNew= new TableRow(getActivity());
                for (int c = 0; c < headersNew.length; c++) {
                    if (c == 1) {
                        addHeaderRow(tableRowHeaderNew, headersNew[c], Color.parseColor("#DFA7A6"));
                    } else {
                        if (c == 2) {
                            addHeaderRow(tableRowHeaderNew, headersNew[c],Color.parseColor("#DFA7A6"));
                        } else {
                            addHeaderRow(tableRowHeaderNew, headersNew[c], Color.parseColor("#DFA7A6"));
                        }

                    }

                }
                tableRowHeaderNew.setLayoutParams(tableRowParams);
                tableLayout.addView(tableRowHeaderNew);
            }

        }

        return tableLayout;
    }

    public void addHeaderRow(TableRow tableRow, String columnName, int color) {

        tableRow.setBackgroundColor(Color.parseColor("#C0504D"));
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        LinearLayout.LayoutParams paramsExample = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        TextView textView = new TextView(getActivity());
        textView.setText(columnName);
        textView.setTypeface(mTfLight,Typeface.BOLD);
        textView.setBackgroundColor(color);
        textView.setMaxWidth(180);
        textView.setTextSize(18f);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(paramsExample);
        tableRow.addView(textView, tableRowParams);

    }


    public void addHeader(TableRow tableRow, String columnName, int color) {

        tableRow.setBackgroundColor(Color.parseColor("#C0504D"));
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        LinearLayout.LayoutParams paramsExample = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        TextView textView = new TextView(getActivity());
        textView.setText(columnName);
        textView.setTypeface(mTfLight);
        textView.setBackgroundColor(color);
        textView.setMaxWidth(180);
        textView.setTextSize(15f);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(paramsExample);
        tableRow.addView(textView, tableRowParams);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}


