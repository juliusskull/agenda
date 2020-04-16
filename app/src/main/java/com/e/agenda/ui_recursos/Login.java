package com.e.agenda.ui_recursos;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.e.agenda.R;
import com.e.agenda.constants.Configuracion;
import com.e.agenda.utils.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;


public class Login extends AppCompatActivity {

        private static final int REQUEST_READ_PHONE_STATE = 1005;
        private static final int REQUEST_UBICACION = 1006;
        private static final int REQUEST_NETWORK_STATE = 1007;
        private static final int REQUEST_FOTO = 1008;
        private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1009;
        private static final int REQUEST_READ_EXTERNAL_STORAGE = 1010;
        public ProgressDialog progress;

        private TextView txt_usuario;
        private TextView txt_password;
        private Gson gson = new Gson();
        //private DatabaseManager dm;

        /* (non-Javadoc)
         * @see com.chatt.custom.CustomActivity#onCreate(android.os.Bundle)
         */

        private Button btn_login;
        private Button btn_salir;
        private boolean isConnected;
        private int permissionCheck_read_phone;
        private int permissionCheck_ubicacion;
        private int permissionCheck_network_state;
        private boolean permiso_granteado_read_phone = false;
        private boolean permiso_granteado_ubicacion = false;
        private boolean permiso_granteado_network_state = false;
        private boolean permiso_camera = false;
        private boolean permiso__external_storage = false;
        private boolean permiso__read_external_storage = false;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //Use text clock
                setContentView(R.layout.login_v3);

            }
            TextView txtVersionApp= findViewById(R.id.txtVersionApp);
            String versionName = "";
            try {
                versionName = getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            txtVersionApp.setText(versionName);

            consultar_permisos();
            txt_usuario =  findViewById(R.id.user);
            txt_password = findViewById(R.id.pwd);
            txt_usuario.setText("julio_gutierrez@cosaysa.com.ar");
            txt_password.setText("123456");
            btn_login =  findViewById(R.id.btnLogin);
            //dm = new DatabaseManager(this);

            btn_login.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    requestLoguin();
                }
            });


            if (Configuracion.SESSION_ACTUAL(Login.this)) {
                volver();
            }
            ini();

            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        }
        protected void ini(){

        }
        public void consultar_permisos() {
            permissionCheck_read_phone = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
            if (permissionCheck_read_phone != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
            } else {
                permiso_granteado_read_phone = true;
            }

            permissionCheck_ubicacion = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            if (permissionCheck_ubicacion != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_UBICACION);
            } else {
                permiso_granteado_ubicacion = true;
            }

            permissionCheck_network_state = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE);
            if (permissionCheck_network_state != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, REQUEST_NETWORK_STATE);
            } else {
                permiso_granteado_network_state = true;
            }

            int permissionCheck_camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            if (permissionCheck_camera != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_FOTO);
            } else {
                permiso_camera = true;
            }

            int permissionCheck_external_storage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck_external_storage != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE);
            } else {
                permiso__external_storage = true;
            }
            int permissionCheck_read_external_storage = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            if (permissionCheck_read_external_storage != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);
            } else {
                permiso__read_external_storage = true;
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            switch (requestCode) {
                case REQUEST_READ_PHONE_STATE:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        permiso_granteado_read_phone = true;
                        consultar_permisos();
                    }
                    break;
                case REQUEST_UBICACION:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        permiso_granteado_ubicacion = true;
                        consultar_permisos();
                    }
                    break;
                case REQUEST_NETWORK_STATE:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        permiso_granteado_network_state = true;
                        consultar_permisos();
                    }
                    break;
                case REQUEST_FOTO:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        permiso_camera = true;
                        consultar_permisos();

                    }


                    break;
                case REQUEST_WRITE_EXTERNAL_STORAGE:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        consultar_permisos();
                        permiso__external_storage = true;


                    }
                    break;
                case REQUEST_READ_EXTERNAL_STORAGE:
                    if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        //TODO
                        permiso__read_external_storage = true;

                    }
                    break;
                default:
                    break;
            }
        }

        @Override
        protected void onStart() {
            // TODO Auto-generated method stub
            super.onStart();
            /*
            Intent intent = new Intent(this, SincronizarService.class);
            startService(intent);
            Intent intent2 = new Intent(this, SincronizarFotosService.class);
            startService(intent2);
            Util.Log("=>Activa");
*/

        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 10 && resultCode == RESULT_OK)
                finish();


            String session = Util.SpGet(Login.this, Configuracion.BIBLIOTECA, Configuracion.SESSION, "");
            //if (session.equals(Configuracion.FIN_DE_DIA)) {
                //dm.add_fin_de_dia();
                //Intent intent = new Intent(this, SincronizarService.class);
                //startService(intent);
            //}
        }


        private void volver() {
            // TODO Auto-generated method stub
            this.finish();
        }

        public byte[] _getBody() throws AuthFailureError {
            JSONObject jsonObject = new JSONObject();
            String body = null;
            try {
                jsonObject.put("usuario", txt_usuario.getText().toString());
                jsonObject.put("password", txt_password.getText().toString());
                jsonObject.put("imei", Util.getIMEI(Login.this));
                body = jsonObject.toString();
                Util.Log("body=>" + body);

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                Log.d("ERROR", "error-Body(1) => " + e.toString());
            }

            try {
                return body.toString().getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                Log.d("ERROR", "error-Body(2) => " + e.toString());
            }
            return null;

        }

        public boolean loguin_sin_conexion() {

            String usuario = Util.SpGet(this, Configuracion.BIBLIOTECA, Configuracion.USUARIO);
            String password = Util.SpGet(this, Configuracion.BIBLIOTECA, Configuracion.PASSWOR);
            if (usuario.equals(txt_usuario.getText().toString())) {
                if (password.equals(txt_password.getText().toString())) {
                    ini_dia();
                    volver();
                } else {
                    return false;
                }
            } else {
                return false;
            }
            return true;
        }
/*
        public boolean requestUsuario() {

            RequestQueue queue = Volley.newRequestQueue(this);


            progress = ProgressDialog.show(Login.this, null, getString(R.string.alert_wait));
            Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                    Configuracion.USUARIO, txt_usuario.getText().toString());
            Util.Log("URL=>(GERENCIA)" + Configuracion.
                    get_Url_Usuarios(Configuracion.get_usuario_actual(Login.this)));
            StringRequest postRequest = new StringRequest(Request.Method.GET, Configuracion.get_Url_Usuarios(Configuracion.get_usuario_actual(Login.this)),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Util.Log("response usuario=>" + response);
                            progress.dismiss();
                            UsuarioList list = gson.fromJson(response, UsuarioList.class);
                            Util.SpSet(Login.this, Configuracion.BIBLIOTECA, Configuracion.GEREN, list.data.get(0).geren);
                            Util.SpSet(Login.this, Configuracion.BIBLIOTECA, Configuracion.USUARIO_ROL, list.data.get(0).rol);
                            volver();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub
                            progress.dismiss();
                            Utils.showDialog(Login.this, "Error  conexion con el servidor al traer la gerencia");

                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Content-Type", "application/json");
                    return params;
                }

                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    // TODO Auto-generated method stub
                    return _getBody();
                }

            };
            int socketTimeout = 30000;//30 seconds - change to what you want
            postRequest.setRetryPolicy(new DefaultRetryPolicy(
                    socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(postRequest);

            return true;

        }
*/
        public void ini_dia() {
            String session = Util.SpGet(Login.this, Configuracion.BIBLIOTECA, Configuracion.SESSION, "");

            if (!session.equals(Configuracion.INICIO_DE_DIA)) {
                Util.SpSet(
                        Login.this, Configuracion.BIBLIOTECA,
                        Configuracion.SESSION, Configuracion.INICIO_DE_DIA);

                Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                        Configuracion.SESSION_FECHA, Util.getFechaActualFormat() + " " + Util.getHoraActualFormat());
               // dm.add_ini_de_dia();

            }

        }

        public boolean requestLoguin() {
            if (!permiso_granteado_read_phone) {
                consultar_permisos();
                return false;
            }
            RequestQueue queue = Volley.newRequestQueue(this);
            final String url = Configuracion.getAuthorizationLoguin();
            Util.Log("url-=>" + url);

            try
            {
                progress = ProgressDialog.show(Login.this, null, getString(R.string.alert_wait));
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Util.Log("response=>(login)" + response);
                                progress.dismiss();

                                Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                                        Configuracion.TOKEN, response.replaceAll("\"", ""));

                                String usuario_anterior = Util.SpGet(Login.this, Configuracion.BIBLIOTECA, Configuracion.USUARIO, "");

                                Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                                        Configuracion.USUARIO_ANTERIOR, usuario_anterior);

                                Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                                        Configuracion.USUARIO, txt_usuario.getText().toString());

                                Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                                        Configuracion.PASSWOR, txt_password.getText().toString());
                                Util.Log(Login.this, "Bienvenido: inicio nuevo!!");
                                ini_dia();
                                borrar_anterior();

                                if (!usuario_anterior.equals(txt_usuario.getText().toString())) {
                                    Util.SpSet(Login.this, Configuracion.BIBLIOTECA,
                                            Configuracion.ACTUALIZACION_OBLIGATORIA, "true");
                                }
                                volver();
                                //requestUsuario();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO Auto-generated method stub
                               // SyncError.ERROR_DISPLAY(error,Login.this);
                                progress.dismiss();

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<>();
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("Content-Type", "application/json");
                        return params;
                    }

                    @Override
                    public String getBodyContentType() {
                        return "application/json";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        // TODO Auto-generated method stub
                        return _getBody();
                    }
                };
                int socketTimeout = 30000;
                postRequest.setRetryPolicy(new DefaultRetryPolicy(
                        socketTimeout,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queue.add(postRequest);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                return loguin_sin_conexion();
            }
            return true;

        }
        public void hideKeybaord() {
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }
        protected void borrar_anterior() {
            // TODO Auto-generated method stub

        }




    }


