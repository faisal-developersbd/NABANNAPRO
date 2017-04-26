package com.developersbd.nabannapro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Visibility;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by TC on 4/14/2017.
 */

public class ResultViewClass extends Fragment{
    View view;
    Button testButton;
    ListView resutlListView;
    ArrayList<listItem> arrayList;
    BaseAdapter adapter;
    BaseAdapter dataAdapter;
    Button methodBtn;
    TextView methodView;
    private String method;
    int fl=0;
    Context context;
    boolean flag=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.resultparent,container,false);
       // testButton= (Button) view.findViewById(R.id.testBtn);
        resutlListView=(ListView) view.findViewById(R.id.lisViewResult);
        methodBtn=(Button) view.findViewById(R.id.actionMethodBtn);
        methodView=(TextView) view.findViewById(R.id.methodView);
        methodView.setText(method);
        methodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(fl==1)
               {
//                   methodView.animate()
//                           .translationY(view.getHeight())
//                           .alpha(0.0f)
//                           .setDuration(300);
                //  methodView.setVisibility(View.GONE);
//                   methodView.animate()
//                           .translationY(methodView.getHeight())
//                           .alpha(1.0f)
//                           .setDuration(1000)
//                           .setListener(new AnimatorListenerAdapter() {
//                               @Override
//                               public void onAnimationEnd(Animator animation) {
//                                   super.onAnimationEnd(animation);
//                                  // methodView.setText(method);
//                               //   methodView.setVisibility(View.GONE);
//
//                               }
//                           });
                   methodView.setVisibility(View.GONE);
                   fl=0;
               }
               else if(fl==0)
               {
                   //methodView.setVisibility(View.VISIBLE);
                   methodView.setVisibility(View.VISIBLE);
//                   methodView.animate()
//                           .translationYBy(methodView.getHeight())
//                           .alpha(1.0f)
//                           .setDuration(300)
//                           .setListener(new AnimatorListenerAdapter() {
//                               @Override
//                               public void onAnimationStart(Animator animation) {
//                                   super.onAnimationStart(animation);
//                                 //  methodView.setText(method);
//
//
//                               }
//                           });
                   fl=1;
               }

            }
        });
        context=getActivity().getBaseContext();
        try{
            adapter=new BaseAdapter() {
                LayoutInflater inflater= (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                @Override
                public int getCount() {
                    return arrayList.size();
                }

                @Override
                public Object getItem(int position) {
                    return arrayList.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return 0;
                }

                @Override
                public View getView(final int position, View view, ViewGroup viewGroup) {
                    if(view==null)
                    {
                        view=inflater.inflate(R.layout.resultlayout,null);
                    }
                    TextView tableHeadedr= (TextView) view.findViewById(R.id.tblHeader);
                    TextView applyingMethod= (TextView) view.findViewById(R.id.methodText);
                    TextView nutQname=(TextView)  view.findViewById(R.id.nutName);
                    TextView nutQt=(TextView) view.findViewById(R.id.nutQuantity);
                    TextView currentNutName=(TextView) view.findViewById(R.id.currentNut);
                    TextView currentNutQt=(TextView) view.findViewById(R.id.currentQuantity);
                   // Button applyViewBtn= (Button) view.findViewById(R.id.methodBtn);

                    tableHeadedr.setText(arrayList.get(position).getTblHeader());

                    currentNutName.setText(arrayList.get(position).getNutElement());
                    currentNutQt.setText(arrayList.get(position).getApplyingMethod());

                    return view;
                }
            };
        }catch (Exception e)
        {
            Log.d("debugadapter","Error: "+e);
        }

        resutlListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
//        testButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//               listItem item=new listItem("NUTRITION ELEMENT","UREA","16 TH/HA");
//                arrayList.add(item);
//                adapter.notifyDataSetChanged();
//            }
//        });
        return view;
    }
    public void setArrayList(ArrayList<listItem> finalElement)
    {
        arrayList=new ArrayList<listItem>();
        arrayList=finalElement;
       String nut= arrayList.get(0).getNutElement();
        Log.d("debugadapter","Nut: "+nut);
        flag=true;

    }

    public void setMethod(String method) {
        this.method = method;

    }
}
