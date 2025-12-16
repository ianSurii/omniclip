import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../controllers/clipboard_controller.dart';

class ClipboardView extends GetView<ClipboardController> {
  const ClipboardView({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('ClipboardView'),
        centerTitle: true,
      ),
      body: const Center(
        child: Text(
          'ClipboardView is working',
          style: TextStyle(fontSize: 20),
        ),
      ),
    );
  }
}
