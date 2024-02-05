import 'package:flutter/material.dart';
import 'package:jtech_togaf_manager_ui/app/theme/color_scheme.dart';
import 'package:jtech_togaf_manager_ui/app/theme/theme_color.dart';

class TogafTheme {
  static ThemeData get themeData {
    return ThemeData(
      primaryColor: TogafColors.red,
      colorScheme: TogafColorScheme.colorScheme,
    );
  }
}
