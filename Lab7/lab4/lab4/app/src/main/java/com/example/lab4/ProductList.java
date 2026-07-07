package com.example.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProductList extends ArrayAdapter<Product> {
    private Activity context;
    List<Product> products;

    public ProductList(Activity context, List<Product> products) {
        super(context, R.layout.layout_product_list, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_product_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);
        Button buttonUpdate = (Button) listViewItem.findViewById(R.id.buttonUpdate);
        Button buttonDelete = (Button) listViewItem.findViewById(R.id.buttonDelete);

        Product product = products.get(position);
        textViewName.setText(product.getProductName());
        textViewPrice.setText(String.valueOf(product.getPrice()));

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MainActivity) {
                    ((MainActivity) context).showUpdateDeleteDialog(product.getId(), product.getProductName());
                }
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dR = FirebaseDatabase.getInstance().getReference("products").child(product.getId());
                dR.removeValue();
                Toast.makeText(context, "Product Deleted", Toast.LENGTH_LONG).show();
            }
        });

        return listViewItem;
    }
}
