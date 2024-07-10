package com.nickmcdonald.runkeepermedalcase.models

import android.media.Image
import java.sql.Time
import java.util.Date

data class Achievement(val sortOrder: Int, val name: String, val imageName: String, var achievedAt: Date?, var bestTime: Time?) {

}
