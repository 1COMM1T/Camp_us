package com.commit.campus.service.impl;

import com.commit.campus.dto.BookmarkDTO;
import com.commit.campus.dto.BookmarkRequest;
import com.commit.campus.entity.Bookmark;
import com.commit.campus.repository.BookmarkRepository;
import com.commit.campus.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public void saveBookmark(BookmarkRequest bookmarkRequest) {
        LocalDateTime currentTime = LocalDateTime.now();

        Bookmark bookmark = new Bookmark();
        bookmark.setUserId(bookmarkRequest.getUserId());
        bookmark.setCampId(bookmarkRequest.getCampId());
        bookmark.setCreatedBookmarkDate(currentTime);
        bookmarkRepository.save(bookmark);
    }

    @Override
    public List<BookmarkDTO> getBookmark(Long userId) {
        List<Bookmark> bookmarks = bookmarkRepository.getBookmark(userId);
        List<BookmarkDTO> bookmarkDTOS = bookmarks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return bookmarkDTOS;
    }

    private BookmarkDTO convertToDTO(Bookmark bookmark) {
        return BookmarkDTO.builder()
                .userId(bookmark.getUserId())
                .campId(bookmark.getCampId())
                .createdBookmarkDate(bookmark.getCreatedBookmarkDate())
                .build();
    }
}
