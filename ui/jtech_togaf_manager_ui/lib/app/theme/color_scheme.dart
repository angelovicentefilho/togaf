import 'package:flutter/material.dart';
import 'package:jtech_togaf_manager_ui/app/theme/theme_color.dart';

class TogafColorScheme {
  static ColorScheme get colorScheme {
    return ColorScheme(
        brightness: Brightness.light,
        primary: TogafColors.primary,
        onPrimary: TogafColors.background,
        secondary: TogafColors.secondary,
        onSecondary: TogafColors.secondary,
        error: TogafColors.accentRed,
        onError: TogafColors.red,
        background: TogafColors.background,
        onBackground: TogafColors.background,
        surface: TogafColors.accentRed,
        onSurface: TogafColors.accentRed);
  }
}
