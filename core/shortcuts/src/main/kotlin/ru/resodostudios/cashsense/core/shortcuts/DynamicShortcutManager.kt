package ru.resodostudios.cashsense.core.shortcuts

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import androidx.core.net.toUri
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.resodostudios.cashsense.core.util.Constants.DEEP_LINK_SCHEME_AND_HOST
import ru.resodostudios.cashsense.core.util.Constants.TARGET_ACTIVITY_NAME
import javax.inject.Inject

private const val HOME_PATH = "home"
private const val WALLET_ID_KEY = "walletId"
private const val OPEN_TRANSACTION_DIALOG_KEY = "openTransactionDialog"
private const val DYNAMIC_TRANSACTION_SHORTCUT_ID = "dynamic_new_transaction"

internal class DynamicShortcutManager @Inject constructor(
    @ApplicationContext private val context: Context,
) : ShortcutManager {

    override fun addTransactionShortcut(
        walletId: String,
        shortLabel: String,
        longLabel: String,
    ) {
        val shortcutInfo = ShortcutInfoCompat.Builder(context, DYNAMIC_TRANSACTION_SHORTCUT_ID)
            .setShortLabel(shortLabel)
            .setLongLabel(longLabel)
            .setIcon(IconCompat.createWithResource(context, R.drawable.ic_shortcut_receipt_long))
            .setIntent(
                Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = "$DEEP_LINK_SCHEME_AND_HOST/$HOME_PATH/$WALLET_ID_KEY=$walletId/$OPEN_TRANSACTION_DIALOG_KEY=true".toUri()
                    component = ComponentName(
                        context.packageName,
                        TARGET_ACTIVITY_NAME,
                    )
                }
            )
            .build()
        ShortcutManagerCompat.pushDynamicShortcut(context, shortcutInfo)
    }

    override fun removeShortcuts() {
        ShortcutManagerCompat.removeAllDynamicShortcuts(context)
    }
}