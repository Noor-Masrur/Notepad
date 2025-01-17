/* Copyright 2021 Braden Farmer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.farmerbb.notepad.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.farmerbb.notepad.ui.routes.AppSettingsRoute
import com.farmerbb.notepad.ui.routes.EditNoteRoute
import com.farmerbb.notepad.ui.routes.NoteListRoute
import com.farmerbb.notepad.ui.routes.NoteListMultiPaneRoute
import com.farmerbb.notepad.ui.routes.ViewNoteRoute
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable fun NotepadComposeApp() {
  val navController = rememberNavController()
  val systemUiController = rememberSystemUiController()

  val configuration = LocalConfiguration.current
  val startDestination =
    if(configuration.screenWidthDp >= 600)
      "NoteListMultiPane"
    else
      "NoteList"

  MaterialTheme {
    NavHost(
      navController = navController,
      startDestination = startDestination
    ) {
      NoteListRoute(navController)
      NoteListMultiPaneRoute(navController)
      ViewNoteRoute(navController)
      EditNoteRoute(navController)
      AppSettingsRoute(navController)
    }
  }

  SideEffect {
    systemUiController.setNavigationBarColor(
      color = Color.White
    )
  }
}