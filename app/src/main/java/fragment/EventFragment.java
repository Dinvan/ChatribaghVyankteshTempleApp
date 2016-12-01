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

public class EventFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TableLayout tableLayout;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    protected Typeface mTfLight;
    public EventFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EventFragment newInstance(String param1, String param2) {
        EventFragment fragment = new EventFragment();
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
        vratModel.setVratName("श्री गुरु पूर्णिमा");
        vratModel.setVratTithi("अषाढ़ शुक्ला १५\n" +
                "मंगलवार");
        vratModel.setVratDate("१९-०७- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री गोदाम्बा जयंती");
        vratModel.setVratTithi("श्रावण शुक्ला ३\n" +

                "शुक्रवार");
        vratModel.setVratDate("०५-०८- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री गोदाम्बा जयंती");
       vratModel.setVratTithi("श्रावण शुक्ला ३\n" +

               "शुक्रवार से");
        vratModel.setVratDate("०५-०८- २०१६ से\n" +

                "२१-०८- २०१६ तक");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री कृष्णा जयंती");
        vratModel.setVratTithi("भाद्रपद कृष्णा ९\n" +

                "शुक्रवार");
        vratModel.setVratDate("२६-०८- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री वामन जयंती");
        vratModel.setVratTithi("भाद्रपद शुक्ला १२\n" +

                "बुधवार");
        vratModel.setVratDate("१४-०९- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री विजयादशमी एवं श्री वेंकटेश\n" +

                "जयंती");
        vratModel.setVratTithi("अश्विन शुक्ला १०\n" +

                "मंगलवार");
        vratModel.setVratDate("११-१०- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री स्वामी बालमुकुंदाचार्य जयंती");
        vratModel.setVratTithi("अश्विन शुक्ला १४\n" +

                "शनिवार");
        vratModel.setVratDate("१५-१०- २०१६");
        list.add(vratModel);

        vratModel=new VratModel();
        vratModel.setVratName("श्री शरद पूर्णिमा");
        vratModel.setVratTithi("अश्विन शुक्ला १५\n" +

                "रविवार");
        vratModel.setVratDate("१६-१०- २०१६");



        list.add(vratModel);
    }


    private TableLayout createEvent() {
        // tableLayout.setBackgroundColor(Color.BLACK);
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,60);
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        String[] headers = {"क्र.","उत्सव एवं जयंतियां", "तिथि", "दिनांक"};
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
