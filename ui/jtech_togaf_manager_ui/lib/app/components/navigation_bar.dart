import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/add_user_page.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_routes.dart';
import 'package:jtech_togaf_manager_ui/app/theme/theme_color.dart';

class NavigationSideBar extends StatelessWidget {
  const NavigationSideBar({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 60,
      color: TogafColors.secondary,
      child: Padding(
        padding: const EdgeInsets.only(top: 60.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: <Widget>[
            const SizedBox(height: 20), // Espaçamento vertical entre os ícones
            Tooltip(
              message: 'Create Projects',
              child: IconButton(
                icon: const Icon(
                  Icons.article_outlined,
                  size: 32,
                ),
                onPressed: () {
                  // Ação para o ícone Home
                },
              ),
            ),
            const SizedBox(height: 20), // Espaçamento vertical entre os ícones
            Tooltip(
              message: 'Create Models',
              child: IconButton(
                icon: const Icon(
                  Icons.note_add_outlined,
                  size: 32,
                ),
                onPressed: () {
                  // Ação para o ícone de Pesquisa
                },
              ),
            ),
            const SizedBox(height: 20), // Espaçamento vertical entre os ícones
            Tooltip(
              message: 'Create Phases',
              child: IconButton(
                icon: const Icon(
                  Icons.assessment_outlined,
                  size: 32,
                ),
                onPressed: () {
                  // Ação para o ícone de Configurações
                },
              ),
            ),
            const SizedBox(height: 20), // Espaçamento vertical entre os ícones
            Tooltip(
              message: 'Create Users',
              child: IconButton(
                icon: const Icon(
                  Icons.person_add_outlined,
                  size: 32,
                ),
                onPressed: () {
                  // Get.toNamed(Routes.ADD_USER);
                  showDialog(
                      context: context,
                      builder: (context) {
                        return AddUserPage();
                      });
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
