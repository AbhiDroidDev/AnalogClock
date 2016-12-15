// Generated code from Butter Knife. Do not modify!
package apps.android.nvm_abhinav_vutukuri.in.analogclock;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  @UiThread
  public MainActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.dial_ImageView = Utils.findRequiredViewAsType(source, R.id.dial_ImageView, "field 'dial_ImageView'", ImageView.class);
    target.minuteHand_ImageView = Utils.findRequiredViewAsType(source, R.id.minuteHand_ImageView, "field 'minuteHand_ImageView'", ImageView.class);
    target.hourHand_ImageView = Utils.findRequiredViewAsType(source, R.id.hourHand_ImageView, "field 'hourHand_ImageView'", ImageView.class);
    target.secondHand_ImageView = Utils.findRequiredViewAsType(source, R.id.secondHand_ImageView, "field 'secondHand_ImageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.dial_ImageView = null;
    target.minuteHand_ImageView = null;
    target.hourHand_ImageView = null;
    target.secondHand_ImageView = null;

    this.target = null;
  }
}
