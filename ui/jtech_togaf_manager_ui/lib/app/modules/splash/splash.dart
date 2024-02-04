import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/home/home_page.dart'; // Importe o GetX

class SplashPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // Use um Future.delayed para criar um atraso de 3 segundos
    Future.delayed(Duration(seconds: 3), () {
      // Use o Get.to() para navegar para a próxima página (por exemplo, HomePage)
      Get.to(() => HomePage());
    });

    return Scaffold(
      backgroundColor: Colors.blue, // Cor de fundo da página
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            // Logotipo fictício
            FlutterLogo(size: 150),
            SizedBox(height: 20),
            Text(
              'Minha Aplicação',
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
