import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_pages.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_routes.dart';
import 'package:jtech_togaf_manager_ui/app/theme/theme.dart';

void main() {
  runApp(TogafApp());
}

class TogafApp extends StatelessWidget {
  const TogafApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'TOGAF Manager',
      theme: TogafTheme.themeData,
      debugShowCheckedModeBanner: false,
      defaultTransition: Transition.fade,
      transitionDuration: const Duration(milliseconds: 200),
      initialRoute: Routes.HOME,
      getPages: TogafPages.pages,
    );
  }
}
