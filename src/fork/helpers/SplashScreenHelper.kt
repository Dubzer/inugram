package desu.inugram.helpers

import android.app.Activity
import android.content.res.Resources
import android.os.Build
import org.telegram.messenger.R
import org.telegram.ui.LauncherIconController
import org.telegram.ui.LauncherIconController.LauncherIcon

object SplashScreenHelper {
    @JvmStatic
    fun sync(activity: Activity?) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S || activity == null) return
        val icon = LauncherIcon.entries.firstOrNull { LauncherIconController.isEnabled(it) }
        val theme = when (icon) {
            LauncherIcon.STOCK, LauncherIcon.DISGUISE -> R.style.InuSplashStock
            LauncherIcon.VINTAGE -> R.style.InuSplashVintage
            LauncherIcon.AQUA -> R.style.InuSplashAqua
            LauncherIcon.PREMIUM -> R.style.InuSplashPremium
            LauncherIcon.TURBO -> R.style.InuSplashTurbo
            LauncherIcon.NOX -> R.style.InuSplashNox
            else -> Resources.ID_NULL
        }
        // Android persists the theme by name and uses it before the app starts next time.
        activity.splashScreen.setSplashScreenTheme(theme)
    }
}
