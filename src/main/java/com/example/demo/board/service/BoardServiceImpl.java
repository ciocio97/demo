package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import com.example.demo.board.domain.dto.ListBoardDTO;
import com.example.demo.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardMapper;

    @Override
    public List<ListBoardDTO> readBoard(int cpg) {
        return boardMapper.selectBoard(cpg);
    }

    @Override
    public Board readOneBoard(int bno) {
        return boardMapper.selectOneBoard(bno);
    }

}
