package io.virtualan.cucumblan.standard;
import io.virtualan.cucumblan.message.typeimpl.JSONMessage;

public class KafkaMessageAggregator implements StandardProcessing {

    @Override
    public String getType() {
        return "AGGREGATE";
    }

    @Override
    public Object responseEvaluator() {
        java.util.Map<String, Object> mapAggregator = io.virtualan.cucumblan.core.msg.kafka.MessageContext.getEventContextMap("MOCK_RESPONSE");
        int count = 0;
        if(mapAggregator != null) {
            for (java.util.Map.Entry<String, Object> entry : mapAggregator.entrySet()) {
                JSONMessage jsonmsg = (JSONMessage) entry.getValue();
                try {
                    if ("doggie".equals(jsonmsg.getMessageAsJson().getString("name"))) {
                        count++;
                    }
                } catch (org.json.JSONException e) {
                }
            }
        }
        org.json.JSONObject object = new org.json.JSONObject();
        try {
            object.put("totalMessageCount", count);
        } catch (org.json.JSONException e) {
        }
        return object;
    }


}
