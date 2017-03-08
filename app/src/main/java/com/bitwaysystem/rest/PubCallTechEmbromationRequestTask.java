package com.bitwaysystem.rest;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.bitwaysystem.utils.TechEmbromationUtils;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Fernando on 21/02/2017.
 */

public class PubCallTechEmbromationRequestTask extends AsyncTask<Void, Void, String> {

    private String messageTechEmbromation;
    private Context mContext;


    public PubCallTechEmbromationRequestTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected String doInBackground(Void... params) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        messageTechEmbromation = restTemplate.getForObject("https://tech-embromation.herokuapp.com", String.class);

        return messageTechEmbromation;
    }

    @Override
    protected void onPostExecute(String messageTechEmbromation) {


        Boolean result= (messageTechEmbromation!=null) ? true : false;
        Intent intent = new Intent(TechEmbromationUtils.CALL_TECH_EMBROMATION_API);

        intent.putExtra(TechEmbromationUtils.RESULT, result);
        intent.putExtra(TechEmbromationUtils.MESSAGE, messageTechEmbromation);

        mContext.sendBroadcast(intent);

        super.onPostExecute(messageTechEmbromation);
    }

}
