package com.example.midtransjava;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.midtransjava.databinding.ActivityMainBinding;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.BillingAddress;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.ShippingAddress;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private int TOTAL_AMOUNT = 0;
    private final String TRANSACTION_ID = "FurnitureRotan-" + System.currentTimeMillis();
    private ActivityMainBinding binding;
    private String id = "101";
    private String nama = "";
    private String email = "";
    private String telepon = "";
    private String idBarang = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        SdkUIFlowBuilder.init()
                .setClientKey("SB-Mid-client-2nfwJhoKrlCwou6q")
                .setContext(getApplicationContext())
                .setTransactionFinishedCallback(result -> {})
                .setMerchantBaseUrl("https://furniture-rotan.000webhostapp.com/index.php/")
                .enableLog(true)
                .setColorTheme(new CustomColorTheme("#FFE51255", "#B61548", "#FFE51255"))
                .setLanguage("en")
                .buildSDK();

            TOTAL_AMOUNT = Integer.parseInt("1000000");
            TransactionRequest transactionRequest = new TransactionRequest(TRANSACTION_ID, TOTAL_AMOUNT);
            ItemDetails itemDetails1 = new ItemDetails("111112234", TOTAL_AMOUNT, 1, "Kursi Rotan");
            transactionRequest.getItemDetails().add(itemDetails1);
            Transaksi transaksi = new Transaksi(
                    idBarang,
                    Integer.parseInt(id),
                    Integer.parseInt("10"),
                    "",
                    "Berhasil",
                    TOTAL_AMOUNT,
                    "Midtrans"
            );
            saveTransaksi(transaksi, getApplicationContext());
            uiKitDetail(transactionRequest);
            MidtransSDK.getInstance().setTransactionRequest(transactionRequest);
            MidtransSDK.getInstance().startPaymentUiFlow(MainActivity.this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void uiKitDetail(TransactionRequest transactionRequest) {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerIdentifier(id);
        customerDetails.setPhone("081345602416");
        customerDetails.setFirstName("DWI");
        customerDetails.setLastName("AJI PANGESTU");
        customerDetails.setEmail("ajipangestu14072001@gmail.com");

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setAddress("Jalan Andalas Gang Sebelah No. 1");
        shippingAddress.setCity("Jakarta");
        shippingAddress.setPostalCode("10220");
        customerDetails.setShippingAddress(shippingAddress);

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setAddress("Jalan Andalas Gang Sebelah No. 1");
        billingAddress.setCity("Jakarta");
        billingAddress.setPostalCode("10220");
        customerDetails.setBillingAddress(billingAddress);

        transactionRequest.setCustomerDetails(customerDetails);
    }

    private void saveTransaksi(Transaksi transaksi, Context context){
        // Logic save ke DataBase
    }

}


