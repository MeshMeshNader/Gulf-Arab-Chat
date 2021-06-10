package com.gulf.arabchat0.modules.merlin;

class BindCallbackManager extends MerlinCallbackManager<Bindable> {

    BindCallbackManager(Register<Bindable> register) {
        super(register);
    }

    void onMerlinBind(NetworkStatus networkStatus) {
        Logger.d("onBind");
        for (Bindable bindable : registerables()) {
            bindable.onBind(networkStatus);
        }
    }
}
