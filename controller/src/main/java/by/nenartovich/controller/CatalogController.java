package by.nenartovich.controller;


import by.nenartovich.*;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/")
/*@SessionAttributes({"person", "nam", "filter"})*/
public class CatalogController {

    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;
    private final ClientRepository clientRepository;
    private final Basket basket;


    @GetMapping("/catalog")
    public String getOrders(){

        return "produkt";

    }


    /*@GetMapping("/orders")
    public String getOrders(@ModelAttribute("nam") Par par,
                            @ModelAttribute("filter") OrderFilter orderFilter,
                            @ModelAttribute("person") ManagerDto managerDto,
                            Model model) throws ParseException {

        System.out.println(par);
       *//* if (par.getDateCreate2() != null) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            try {
                Date docDate = format.parse(par.getDateCreate2());
                System.out.println(docDate);
                orderFilter.setDateCreate(docDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }*//*
        orderFilter.setManagerDto(managerDto);
        System.out.println(orderFilter);
        Page<OrderDto> page = managerService.findAllPaginated(orderFilter, par);
        par.setGetTotalPages(page.getTotalPages());
        par.setGetTotalElements(page.getTotalElements());
        model.addAttribute("orders", page);
        return "/manager/orders";
    }

    *//*@GetMapping("/orders/{pageNumber}")
    public String index(@ModelAttribute("nam") Par par, @ModelAttribute("filter") OrderFilter orderFilter,
            *//**//*@PathVariable(value = "pageNumber") int pageNumber,
                        @RequestParam("sortDir") String sortDir,*//**//* Model model, HttpSession session) {
     *//**//*OrderFilter orderFilter = OrderFilter.builder()
                //.dateCreate(date)
        //.dateCreate(orderService.findById(1L).getDateChange())
                 .client(clientRepository.getReferenceById(1L))
                .build();*//**//*
     *//**//* OrderFilter orderFilter2 = (OrderFilter) session.getAttribute("filter");

        System.out.println(orderFilter2);
        System.out.println(orderFilter);*//**//*

        //Par par = (Par) session.getAttribute("nam");

        System.out.println(par);
        Page<OrderDto> page = managerService.findAllPaginated(orderFilter, par.getPageNumber() *//**//*pageNumber*//**//*, par.getPageSize(), par.getSortField(), par.getSortDir() *//**//*sortDir*//**//*);
        par.setGetTotalPages(page.getTotalPages());
        par.setGetTotalElements(page.getTotalElements());
        List<OrderDto> orders = page.getContent();
        //model.addAttribute("currentPage", pageNumber);
        //model.addAttribute("totalPages", totalPages);
        //model.addAttribute("totalItems", totalItems);
        //model.addAttribute("sortDir", sortDir);
        //model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("orders", page);
        //model.addAttribute("manager", managerName);
        return "/manager/orders";
    }*//*


    @GetMapping("/order/new")
    public String newOrder(Model model) {
        OrderDto orderDto = new OrderDto();
        ClientDto clientDto = new ClientDto();
        AddressDto addressDto = new AddressDto();
        model.addAttribute("order", orderDto);
        model.addAttribute("client", clientDto);
        model.addAttribute("address", addressDto);
        model.addAttribute("deliverys", deliveryService.findAllDeliveryDto());
        model.addAttribute("products", productService.findAllProductDto());
        return "/manager/order-create";
    }

    @PostMapping("/orders")
    public String create(@ModelAttribute("order") OrderDto orderDto,
                         @RequestParam("answerList") Long[] answerList,
                         @ModelAttribute("address") AddressDto addressDto,
                         @ModelAttribute("client") ClientDto clientDto, Principal principal) {
        List<Long> list = new ArrayList<>();
        Collections.addAll(list, answerList);
        List<ProductDto> productDtos = list.stream().map(productService::findById).collect(Collectors.toList());
        ManagerDto managerDto = managerService.findByName(principal.getName());
        clientDto.setAddress(addressDto);
        orderDto.setClient(clientService.save(clientDto));
        orderDto.setProducts(productDtos);
        orderDto.setManager(managerDto);
        orderService.save(orderDto);
        return "redirect:/manager/orders";
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        try {
            Date docDate = format.parse("2022-07-12");
            System.out.println(docDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @ModelAttribute("person")
    public ManagerDto populatePerson(Principal principal) {
        return managerService.findByName(principal.getName());
    }

    @ModelAttribute("nam")
    public Par populateName() {
        return Par.builder().build();
    }

    @ModelAttribute("filter")
    public OrderFilter populateFilter() {
        return OrderFilter.builder().build();
    }*/
}