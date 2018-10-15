package com.example.caesar.opellaapp.WalletPay;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cooltechworks.creditcarddesign.CardEditActivity;
import com.cooltechworks.creditcarddesign.CreditCardUtils;
import com.cooltechworks.creditcarddesign.CreditCardView;
import com.example.caesar.opellaapp.OpeleModel;
import com.example.caesar.opellaapp.R;
import com.example.caesar.opellaapp.Test3DRotateActivity;
import com.example.caesar.opellaapp.TestOpele;
import com.squareup.picasso.Picasso;

import co.paystack.android.Paystack;
import co.paystack.android.PaystackSdk;
import co.paystack.android.Transaction;
import co.paystack.android.model.Card;
import co.paystack.android.model.Charge;

public class CreditCardPaystack extends AppCompatActivity {

    private final int CREATE_NEW_CARD = 0;
    private final int PAY_NEW_CARD = 14;
    public static final String EXTRA_POSITION = "position";

    private LinearLayout cardContainer;
    private Button addCardButton, payCardButton;
    private Card card;
    private Charge charge;
    public static final String EXTRA_PAY__ORDER_amount = "title";
    private ImageView payImageView;
    private TextView textPrice;
    private CardView card_viewImageView;
    CreditCardView creditCardView;
    String cardNumber;
    String expiry ;
    String cardHolderName;
    String cvv ;
    int amount ;
    NotificationCompat.Builder notification;
    private static final int uniqueId = 646843;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaystackSdk.initialize(getApplicationContext());
        setContentView(R.layout.activity_credit_card_paystack);


        initialize();
        listeners();
        card_viewImageView = findViewById(R.id.card_viewImageView);
        payImageView = findViewById(R.id.payImageView);
        textPrice = findViewById(R.id.textPrice);
        if (getIntent().getExtras() != null) {

            amount = getIntent().getExtras().getInt(EXTRA_PAY__ORDER_amount);
            int pizzano = (int) getIntent().getExtras().get(EXTRA_POSITION);

            int pizzaimage = OpeleModel.pizzas[pizzano].getImageResourceId();

            payImageView.setImageDrawable(getResources().getDrawable(pizzaimage));
            String amount_text = String.valueOf(amount);
            textPrice.setText(amount_text);

        }else {
            payImageView.setImageDrawable(getResources().getDrawable(R.drawable.opelebigfront));
            textPrice.setText("");
        }


    }

    private void initialize() {
        addCardButton = (Button) findViewById(R.id.add_card);

        cardContainer = (LinearLayout) findViewById(R.id.card_container);
//        getSupportActionBar().setTitle("OrakuWallet");
//        populate();
    }

    private void populate() {
        CreditCardView sampleCreditCardView = new CreditCardView(this);

        String name = "Sample Card";
        String cvv = "420";
        String expiry = "01/18";
        String cardNumber = "4242424242424242";

        sampleCreditCardView.setCVV(cvv);
        sampleCreditCardView.setCardHolderName(name);
        sampleCreditCardView.setCardExpiry(expiry);
        sampleCreditCardView.setCardNumber(cardNumber);

        cardContainer.addView(sampleCreditCardView);
        int index = cardContainer.getChildCount() - 1;
        addCardListener(index, sampleCreditCardView);
    }

    private void listeners() {
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CreditCardPaystack.this, CardEditActivity.class);
                startActivityForResult(intent, CREATE_NEW_CARD);
            }
        });
    }

    private void addCardListener(final int index, CreditCardView creditCardView) {
        creditCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreditCardView creditCardView = (CreditCardView) v;
                cardNumber = creditCardView.getCardNumber();
                expiry = creditCardView.getExpiry();
                cardHolderName = creditCardView.getCardHolderName();
                cvv = creditCardView.getCVV();

                Intent intent = new Intent(CreditCardPaystack.this, CardEditActivity.class);
                intent.putExtra(CreditCardUtils.EXTRA_CARD_HOLDER_NAME, cardHolderName);
                intent.putExtra(CreditCardUtils.EXTRA_CARD_NUMBER, cardNumber);
                intent.putExtra(CreditCardUtils.EXTRA_CARD_EXPIRY, expiry);
                intent.putExtra(CreditCardUtils.EXTRA_CARD_SHOW_CARD_SIDE, CreditCardUtils.CARD_SIDE_BACK);
                intent.putExtra(CreditCardUtils.EXTRA_VALIDATE_EXPIRY_DATE, false);
                intent.putExtra(CreditCardUtils.EXTRA_CARD_CVV, cvv);

                // start at the CVV activity to edit it as it is not being passed
                intent.putExtra(CreditCardUtils.EXTRA_ENTRY_START_PAGE, CreditCardUtils.CARD_CVV_PAGE);
                startActivityForResult(intent, index);
            }
        });
    }
    private void performCharge() {
        //create a Charge object
        charge = new Charge();

        //set the card to charge
        charge.setCard(card);

        //call this method if you set a plan
        //charge.setPlan("PLN_yourplan");

//        charge.setEmail(email); //dummy email address

        charge.setAmount(amount); //test amount

        PaystackSdk.chargeCard(CreditCardPaystack.this, charge, new Paystack.TransactionCallback() {
            @Override
            public void onSuccess(Transaction transaction) {
                // This is called only after transaction is deemed successful.
                // Retrieve the transaction, and send its reference to your server
                // for verification.
                String paymentReference = transaction.getReference();
                Toast.makeText(CreditCardPaystack.this, "Transaction Successful! payment reference: "
                        + paymentReference, Toast.LENGTH_LONG).show();
//                if (statusListenerChild != null){
//                    statusListenerChild.status(paymentReference, "your order is been processed...");
//                    HomeFragment.startHomefragment(TestPayStack.this);
//                }
                Intent intent = new Intent(CreditCardPaystack.this, Test3DRotateActivity.class);
//                intent.putExtra(OrderActivity.EXTRA_SUCCESFUL_MESSAGE, "Your order would be delivered shortly thanks for patronage...");

                PendingIntent pendingIntent = PendingIntent.getActivity(CreditCardPaystack.this,0, intent, PendingIntent.FLAG_UPDATE_CURRENT);


                notification.setTicker("your Order was Succesful");
                notification.setContentTitle("Corral Fits");
                notification.setContentText("Order Succcesful ");
                notification.setWhen(System.currentTimeMillis());
                notification.setSmallIcon(R.drawable.opelebigback);
                notification.setLights(Color.BLUE, 500, 500);
                long[] pattern ={500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500};
                notification.setVibrate(pattern);
                notification.setStyle(new NotificationCompat.InboxStyle());
                Uri alarmsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                notification.setSound(alarmsound);
                notification.setContentIntent(pendingIntent);

                NotificationManager notmanage = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notmanage.notify(uniqueId, notification.build());


                Intent dintent = new Intent(CreditCardPaystack.this, Test3DRotateActivity.class);
//                dintent.putExtra(OrderActivity.EXTRA_SUCCESFUL_MESSAGE, "Your order would be delivered within 2 weeks...");
                startActivity(dintent);
            }

            @Override
            public void beforeValidate(Transaction transaction) {
                // This is called only before requesting OTP.
                // Save reference so you may send to server. If
                // error occurs with OTP, you should still verify on server.
            }

            @Override
            public void onError(Throwable error, Transaction transaction) {
                //handle error here
            }
        });
    }

    public void onActivityResult(int reqCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
//            Debug.printToast("Result Code is OK", getApplicationContext());

            String name = data.getStringExtra(CreditCardUtils.EXTRA_CARD_HOLDER_NAME);
            String cardNumber = data.getStringExtra(CreditCardUtils.EXTRA_CARD_NUMBER);
            String expiry = data.getStringExtra(CreditCardUtils.EXTRA_CARD_EXPIRY);
            String cvv = data.getStringExtra(CreditCardUtils.EXTRA_CARD_CVV);

            if (reqCode == CREATE_NEW_CARD) {

                CreditCardView creditCardView = new CreditCardView(this);

                creditCardView.setCVV(cvv);
                creditCardView.setCardHolderName(name);
                creditCardView.setCardExpiry(expiry);
                creditCardView.setCardNumber(cardNumber);

                cardContainer.addView(creditCardView);
                int index = cardContainer.getChildCount() - 1;
                addCardListener(index, creditCardView);

                addCardButton.setVisibility(View.INVISIBLE);
                try {
//                    email = emailField.getText().toString().trim();
//                    cardNumber = cardNumberField.getText().toString().trim();
//                    expiryMonth = Integer.parseInt(expiryMonthField.getText().toString().trim());
//                    expiryYear = Integer.parseInt(expiryYearField.getText().toString().trim());
//                    cvv = cvvField.getText().toString().trim();
//                    amount = Integer.parseInt(textPrice.getText().toString().trim());

                    //String cardNumber = "4084084084084081";
                    //int expiryMonth = 11; //any month in the future
                    //int expiryYear = 18; // any year in the future
                    //String cvv = "408";

                    int month = Integer.parseInt(expiry.substring(0, 2));
                    int year = Integer.parseInt(expiry.substring(3, 5));
                    card = new Card(cardNumber.trim(), month, year, cvv.trim());

                    if (card.isValid()) {
                        Toast.makeText(CreditCardPaystack.this, "Card is Valid", Toast.LENGTH_LONG).show();
                        performCharge();
                    } else {
                        Toast.makeText(CreditCardPaystack.this, "Card not Valid", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            else {

                CreditCardView creditCardView = (CreditCardView) cardContainer.getChildAt(reqCode);

                creditCardView.setCardExpiry(expiry);
                creditCardView.setCardNumber(cardNumber);
                creditCardView.setCardHolderName(name);
                creditCardView.setCVV(cvv);

            }
        }

    }

}
