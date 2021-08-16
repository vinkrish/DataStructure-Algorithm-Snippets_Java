package classes;

class RemoteClass {
	private OnChangeListener mOnChangeListener;

	void makeSomeChanges() {
		// do something and call callback here
		mOnChangeListener.onChanged(this, 1);
	}
	
	public void setOnChangeListener(OnChangeListener listener) {
        mOnChangeListener = listener;
    }
	
	public interface OnChangeListener {
        public void onChanged(RemoteClass remoteClass, int test);
    }

}

class Callback {
	
	public static void main(String[] args) {		
		RemoteClass obj = new RemoteClass();
		obj.setOnChangeListener(demoChanged);
		obj.makeSomeChanges();
	}
	
	private static RemoteClass.OnChangeListener demoChanged = new RemoteClass.OnChangeListener() {
        @Override
        public void onChanged(RemoteClass remoteClass, int incoming) {
            switch (incoming) {
                case 1:
                	System.out.println("I will take appropriate action!");
                    break;
                default:
                    break;
            }

        }
    };
    
}
