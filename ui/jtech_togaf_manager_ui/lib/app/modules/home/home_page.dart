import 'package:flutter/material.dart';
import 'package:jtech_togaf_manager_ui/app/components/navigation_bar.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Row(
        children: <Widget>[
          const NavigationSideBar(),
          Expanded(
            child: Column(
              children: <Widget>[
                AppBar(
                  title: const Text('Jtech TOGAF Manager'),
                  // elevation: 0, // Remove a sombra abaixo do AppBar
                ),
                const Expanded(
                  child: Center(
                    child: Text('Conteúdo principal aqui'),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
