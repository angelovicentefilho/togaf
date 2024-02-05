import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user_controller.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_pages.dart';
import 'package:get/get.dart';
import 'package:flutter/material.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_routes.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user_controller.dart';
import 'package:jtech_togaf_manager_ui/app/routes/app_routes.dart';

class UserListController extends GetxController {
  final UserController _userController = UserController();
  final TextEditingController _searchController = TextEditingController();

  RxList<User> userList = <User>[].obs;

  @override
  void onInit() {
    super.onInit();
    userList.assignAll(_userController.getAllUsers());
    _searchController.addListener(_filterUsers);
  }

  void _filterUsers() {
    String searchTerm = _searchController.text.toLowerCase();
    userList.assignAll(_userController.getAllUsers().where((user) {
      return user.username.toLowerCase().contains(searchTerm) ||
          user.email.toLowerCase().contains(searchTerm);
    }).toList());
  }

  void editUser(User user) {
    Get.toNamed(Routes.UPD_USER, arguments: user);
  }

  void searchUser(String value) {}

  void showDeleteConfirmationDialog(User user) {
    Get.defaultDialog(
      title: 'Confirmar Exclusão',
      middleText: 'Tem certeza de que deseja excluir este usuário?',
      textConfirm: 'Sim',
      textCancel: 'Não',
      confirmTextColor: Colors.white,
      onConfirm: () {
        deleteUser(user);
        Get.back(); // Fecha a caixa de diálogo
      },
      onCancel: () {
        Get.back(); // Fecha a caixa de diálogo
      },
    );
  }

  void deleteUser(User user) {
    userList.remove(user);
  }

  void showUserDetailsModal(User user) {
    Get.defaultDialog(
      title: 'Detalhes do Usuário',
      content: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('Username: ${user.username}'),
          Text('Email: ${user.email}'),
          Text('Role: ${user.role}'),
        ],
      ),
      confirm: ElevatedButton(
        onPressed: () {
          Get.back(); // Fecha a modal
        },
        child: const Text('OK'),
      ),
    );
  }
}
