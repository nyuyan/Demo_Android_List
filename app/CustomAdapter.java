import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<AndroidVersion>versionList;

    public CustomAdapter(Context context, int resource, ArrayList<AndroidVersion>object) {
        super(context, resource,object);

        parent_context= context;
        layout_id=resource;
        versionList=object;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvVersion = rowView.findViewById(R.id.textViewVersion);

        AndroidVersion currentVersion = versionList.get(position);

        tvName.setText(currentVersion.getName());
        tvVersion.setText(currentVersion.getVersion());

        return rowView;
    }
}
