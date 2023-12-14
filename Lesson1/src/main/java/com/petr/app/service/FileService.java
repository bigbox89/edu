package com.petr.app.service;

import com.petr.app.dto.Contact;
import java.util.ArrayList;

/**
 * Интерфейс FileService для получения списка контактов из файла.
 */
public interface FileService {
      ArrayList<Contact> getFileContacts();
}
