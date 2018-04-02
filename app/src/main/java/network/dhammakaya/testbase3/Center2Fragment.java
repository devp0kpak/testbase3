package network.dhammakaya.testbase3;


import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import network.dhammakaya.testbase3.Bean.ProductBean;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static network.dhammakaya.testbase3.Bean.ProductBean.BASE_URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Center2Fragment extends Fragment {


    private RecyclerView mRecyclerview;
    private ArrayList<ProductBean> mData;

    public Center2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_center2, container, false);

        mRecyclerview = (RecyclerView) view.findViewById(R.id.rv_center_2);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        feedData();
    }

    private void feedData() {
        new FeedAsyn().execute(BASE_URL + "query.php");
    }

    private class FeedAsyn extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                OkHttpClient _OkHttpClient = new OkHttpClient();

                Request _request = new Request.Builder().url(strings[0]).get().build();

                Response _response = _OkHttpClient.newCall(_request).execute();

                String _result = _response.body().string();

                Gson _gson = new Gson();

                Type type = new TypeToken<List<ProductBean>>() {}.getType();

                mData = _gson.fromJson(_result, type);

                return "successfully";

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (result != null){
                mRecyclerview.setAdapter(new CustomRecyclerViewC2(mData,getContext()));
            } else {
                Toast.makeText(getActivity(), "Feed Data Failure", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
