package com.example.caesar.opellaapp.WalletPay;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.caesar.opellaapp.Adapters.WalletAdapter;
import com.example.caesar.opellaapp.R;

import java.util.ArrayList;

public class WalletActivity extends AppCompatActivity {
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Drawable> mImageUrls = new ArrayList<>();

    private static final String TAG = "WalletActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        Uri uriS = Uri.parse("R.drawable.smallseeds");
        Uri uriM = Uri.parse("R.drawable.mediumseeds");
        Uri uriL = Uri.parse("R.drawable.largeseeds");
        Uri uriXL = Uri.parse("R.drawable.extralargeseeds");
//        mImageUrls.add(uriS);
//        mImageUrls.add(uriM);
//        mImageUrls.add(uriL);
//        mImageUrls.add(uriXL);
        mImageUrls.add( getResources().getDrawable(R.drawable.smallseeds));
        mImageUrls.add( getResources().getDrawable(R.drawable.mediumseeds));
        mImageUrls.add( getResources().getDrawable(R.drawable.largeseeds));
        mImageUrls.add( getResources().getDrawable(R.drawable.extralargeseeds));

        mNames.add("Buy few seeds for 500 naira");
        mNames.add("Buy more seeds for 1000 naira");
        mNames.add("Buy many seeds for 3000 naira");
        mNames.add("Buy unlimited seeds for 5000 naira");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        WalletAdapter adapter = new WalletAdapter(this, mNames, mImageUrls);
        adapter.setListener(new WalletAdapter.Listener(){
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(WalletActivity.this, CreditCardPaystack.class);
                switch (position){
                    case 0:
                        intent.putExtra(CreditCardPaystack.EXTRA_POSITION, position);
                        intent.putExtra(CreditCardPaystack.EXTRA_PAY__ORDER_amount, 500 );
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra(CreditCardPaystack.EXTRA_POSITION, position);
                        intent.putExtra(CreditCardPaystack.EXTRA_PAY__ORDER_amount, 1000 );
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra(CreditCardPaystack.EXTRA_POSITION, position);
                        intent.putExtra(CreditCardPaystack.EXTRA_PAY__ORDER_amount, 3000 );
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra(CreditCardPaystack.EXTRA_POSITION, position);
                        intent.putExtra(CreditCardPaystack.EXTRA_PAY__ORDER_amount, 5000 );
                        startActivity(intent);
                        break;
                }
                intent.putExtra(CreditCardPaystack.EXTRA_POSITION, position);

                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }
}
