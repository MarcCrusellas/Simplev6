package com.neuro.simplev6.ui.notifications;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.neuro.simplev6.R;
import com.neuro.simplev6.databinding.FragmentNotificationsBinding;
import com.neuro.simplev6.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.HashSet;


public class NotificationsFragment extends Fragment {


    private FragmentNotificationsBinding binding;
    CardView cardView, cardView2;

    public static ArrayList<String> contats = new ArrayList<>();
    AppCompatImageButton img3;
    public static ArrayAdapter arrayAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        img3= binding.img3;
        // prova
// test
        // toolbar.setNavigationIcon(R.drawable.ic_action_menu);
        ListView listView = binding.listViewcard;
        SharedPreferences sharedPref = getContext().getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPref.getStringSet("contats", null);
        if (set == null){
            contats.add("escrive aqui");
        } else {
            contats = new ArrayList<>(set);
        }
        arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_note,contats);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDelete= i;
                new androidx.appcompat.app.AlertDialog.Builder(getContext())
                        .setTitle("Quieres borrar la nota?")
                        .setIcon(R.drawable.ic_baseline_delete_sweep_24)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick (DialogInterface dialog,int i){
                                contats.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPref = getContext().getSharedPreferences("com.neuro.simplev6", Context.MODE_PRIVATE);
                                HashSet<String> set = new HashSet<>(DashboardFragment.notes);
                                sharedPref.edit().putStringSet("notes", set).apply();
                            }
                        })

                        .setNegativeButton("No",null)
                        .show();
                return true;

            }
        });
        img3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                contats();
                Toast.makeText(getActivity(), "hasta aqui si", Toast.LENGTH_LONG).show();
                // Intent intent2 = new Intent(getContext(), NotesActivity.class);
                // startActivity(intent2);
                // notes.add("escrive aqui");
                // ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
            }
        });

        cardView = binding.cardView;
        cardView2= binding.cardView2;
        cardView.setOnClickListener(v -> call(1));
        cardView2.setOnClickListener(v -> call(2) );

        return root;
    }

    private void call(int i) {

        if (i == 1) {
            Intent emergencias = new Intent(Intent.ACTION_DIAL);
            emergencias.setData(Uri.parse("tel:112"));
            startActivity(emergencias);
        } else if(i == 2){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("A que Policia? (Preferiblemente emergencias)");
            builder.setNegativeButton("back",null);

            String[] animals = { "Mossos d'esquadra","Guardia Civil","Ertzaintza","Policía Foral de Navarra"};
            builder.setItems(animals, (dialog, which) -> {
                switch (which) {
                    case 0:
                        Intent Mossos = new Intent(Intent.ACTION_DIAL);
                        Mossos.setData(Uri.parse("tel:012"));
                        startActivity(Mossos);
                        break;
                    case 1:
                        Intent Guardia = new Intent(Intent.ACTION_DIAL);
                        Guardia.setData(Uri.parse("tel:062"));
                        startActivity(Guardia);
                        break;
                    case 2:
                        Intent Ertzaintza = new Intent(Intent.ACTION_DIAL);
                        Ertzaintza.setData(Uri.parse("tel:900 103 584"));
                        startActivity(Ertzaintza);
                        break;
                    case 3:
                        Intent Foral = new Intent(Intent.ACTION_DIAL);
                        Foral.setData(Uri.parse("tel:848 426 853"));
                        startActivity(Foral);
                        break;
// 061
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void contats() {
        if(!hasPhoneContactsPermission(Manifest.permission.READ_CONTACTS))
        {
            requestPermission(Manifest.permission.READ_CONTACTS);
        }else {
            // getAllContacts();
            Toast.makeText(getContext(), "work", Toast.LENGTH_SHORT).show();
        }
    }

    // Check whether user has phone contacts manipulation permission or not.
    private boolean hasPhoneContactsPermission(String permission)
    {
        boolean ret = false;
        // If android sdk version is bigger than 23 the need to check run time permission.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // return phone read contacts permission grant status.
            int hasPermission = ContextCompat.checkSelfPermission(getContext(), permission);
            // If permission is granted then return true.
            if (hasPermission == PackageManager.PERMISSION_GRANTED) {
                ret = true;
            }
        }else
        {
            ret = true;
        }
        return ret;
    }

    private void requestPermission(String permission)
    {
        String requestPermissionArray[] = {permission};
        ActivityCompat.requestPermissions(getActivity(), requestPermissionArray, 1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int length = grantResults.length;
        if(length > 0)
        {
            int grantResult = grantResults[0];
            if(grantResult == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "You allowed permission, please click the button again.", Toast.LENGTH_LONG).show();
            }else
            {
                Toast.makeText(getContext(), "You denied permission.", Toast.LENGTH_LONG).show();
            }
        }
    }


    /* Return all contacts and show each contact data in android monitor console as debug info.
    private List<ContactDTO> getAllContacts()
    {
        List<ContactDTO> ret = new ArrayList<ContactDTO>();
        // Get all raw contacts id list.
        List<Integer> rawContactsIdList = getRawContactsIdList();
        int contactListSize = rawContactsIdList.size();
        ContentResolver contentResolver = getContentResolver();
        // Loop in the raw contacts list.
        for(int i=0;i<contactListSize;i++)
        {
            // Get the raw contact id.
            Integer rawContactId = rawContactsIdList.get(i);
            Log.d(TAG_ANDROID_CONTACTS, "raw contact id : " + rawContactId.intValue());
            // Data content uri (access data table. )
            Uri dataContentUri = ContactsContract.Data.CONTENT_URI;
            // Build query columns name array.
            List<String> queryColumnList = new ArrayList<String>();
            // ContactsContract.Data.CONTACT_ID = "contact_id";
            queryColumnList.add(ContactsContract.Data.CONTACT_ID);
            // ContactsContract.Data.MIMETYPE = "mimetype";
            queryColumnList.add(ContactsContract.Data.MIMETYPE);
            queryColumnList.add(ContactsContract.Data.DATA1);
            queryColumnList.add(ContactsContract.Data.DATA2);
            queryColumnList.add(ContactsContract.Data.DATA3);
            queryColumnList.add(ContactsContract.Data.DATA4);
            queryColumnList.add(ContactsContract.Data.DATA5);
            queryColumnList.add(ContactsContract.Data.DATA6);
            queryColumnList.add(ContactsContract.Data.DATA7);
            queryColumnList.add(ContactsContract.Data.DATA8);
            queryColumnList.add(ContactsContract.Data.DATA9);
            queryColumnList.add(ContactsContract.Data.DATA10);
            queryColumnList.add(ContactsContract.Data.DATA11);
            queryColumnList.add(ContactsContract.Data.DATA12);
            queryColumnList.add(ContactsContract.Data.DATA13);
            queryColumnList.add(ContactsContract.Data.DATA14);
            queryColumnList.add(ContactsContract.Data.DATA15);
            // Translate column name list to array.
            String queryColumnArr[] = queryColumnList.toArray(new String[queryColumnList.size()]);
            // Build query condition string. Query rows by contact id.
            StringBuffer whereClauseBuf = new StringBuffer();
            whereClauseBuf.append(ContactsContract.Data.RAW_CONTACT_ID);
            whereClauseBuf.append("=");
            whereClauseBuf.append(rawContactId);
            // Query data table and return related contact data.
            Cursor cursor = contentResolver.query(dataContentUri, queryColumnArr, whereClauseBuf.toString(), null, null);

            if(cursor!=null && cursor.getCount() > 0)
            {
                StringBuffer lineBuf = new StringBuffer();
                cursor.moveToFirst();
                lineBuf.append("Raw Contact Id : ");
                lineBuf.append(rawContactId);
                long contactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID));
                lineBuf.append(" , Contact Id : ");
                lineBuf.append(contactId);
                do{
                    // First get mimetype column value.
                    String mimeType = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                    lineBuf.append(" \r\n , MimeType : ");
                    lineBuf.append(mimeType);
                    List<String> dataValueList = getColumnValueByMimetype(cursor, mimeType);
                    int dataValueListSize = dataValueList.size();
                    for(int j=0;j < dataValueListSize;j++)
                    {
                        String dataValue = dataValueList.get(j);
                        lineBuf.append(" , ");
                        lineBuf.append(dataValue);
                    }
                }while(cursor.moveToNext());
                Log.d(TAG_ANDROID_CONTACTS, lineBuf.toString());
            }
            Log.d(TAG_ANDROID_CONTACTS, "=========================================================================");
        }
        return ret;
    }
                */
}