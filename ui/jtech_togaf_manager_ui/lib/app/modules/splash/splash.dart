import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/home/home_page.dart';
import 'package:jtech_togaf_manager_ui/app/theme/theme_color.dart'; // Importe o GetX

class SplashPage extends StatelessWidget {
  const SplashPage({super.key});

  @override
  Widget build(BuildContext context) {
    Future.delayed(const Duration(seconds: 3), () {
      Get.to(() => const HomePage());
    });

    return const Scaffold(
      backgroundColor: TogafColors.accentRed, // Cor de fundo da página
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // Logotipo fictício
            FlutterLogo(size: 150),
            SizedBox(height: 20),
            Text(
              'TOGAF',
              style: TextStyle(
                color: Colors.white,
                fontSize: 24,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
