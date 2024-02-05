import 'package:jtech_togaf_manager_ui/app/modules/home/home_page.dart';
import 'package:jtech_togaf_manager_ui/app/modules/splash/splash.dart';
import 'package:get/get.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/add_user_page.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/edit_user_page.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/list_user_page.dart';
import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart';

import 'app_routes.dart';

abstract class TogafPages {
  static final pages = [
    GetPage(
      name: Routes.INITIAL,
      page: () => SplashPage(),
    ),

    GetPage(
      name: Routes.HOME,
      page: () => HomePage(),
    ),
    GetPage(
      name: Routes.ADD_COMMENT,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.ADD_MODEL,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.ADD_PHASE,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.ADD_PROJECT,
      page: () => SplashPage(),
    ),

    //-------------------------------------------------------------------------
    GetPage(
      name: Routes.UPD_COMMENT,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.UPD_MODEL,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.UPD_PHASE,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.UPD_PROJECT,
      page: () => SplashPage(),
    ),

    //-------------------------------------------------------------------------
    GetPage(
      name: Routes.DEL_COMMENT,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.DEL_MODEL,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.DEL_PHASE,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.DEL_PROJECT,
      page: () => SplashPage(),
    ),

    //-------------------------------------------------------------------------
    // Users
    //-------------------------------------------------------------------------
    GetPage(
      name: Routes.DEL_USER,
      page: () => SplashPage(),
    ),
    GetPage(
      name: Routes.UPD_USER,
      page: () {
        final user = Get.arguments as User;
        return EditUserPage(user: user);
      },
    ),
    GetPage(
      name: Routes.ADD_USER,
      page: () => AddUserPage(),
    ),
    GetPage(
      name: Routes.LIST_USER,
      page: () => UserListPage(),
    ),
  ];
}
