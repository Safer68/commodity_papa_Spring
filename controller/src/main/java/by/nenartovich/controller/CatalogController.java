package by.nenartovich.controller;


import by.nenartovich.ProductService;
import by.nenartovich.dto.ProductDto;
import by.nenartovich.utils.FileNameUtils;
import by.nenartovich.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
/*@SessionAttributes({"person", "parameter", "filter"})*/
public class CatalogController {

    private final ProductService productService;

    @GetMapping("/manager/catalog")
    public String getProducts(Model model) {
        List<ProductDto> productDtoList = productService.findAllProductDto();
        model.addAttribute("products", productDtoList);
        return "/manager/catalog";
    }

    @GetMapping("/manager/product/new")
    public String getProduct(Model model) {
        model.addAttribute("product", new ProductDto());
        return "/manager/product";
    }

    @GetMapping("/manager/product/update/{id}")
    public String getProduct(Model model, @PathVariable("id") long id) {
        ProductDto productDto = productService.findById(id);
        System.out.println(productDto);
        System.out.println("--------------------------------------------------------------------------------");
        model.addAttribute("product", productDto);
        return "/manager/product-update";
    }

    @PostMapping("/manager/catalog2")
    public String createProducts(@ModelAttribute("product") ProductDto productDto,
                                 @Value("${web.upload-path}") String path,
                                 @RequestParam ("file") MultipartFile file) {
        System.out.println(productDto);
        if (0 != file.getSize()) {
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            System.out.println(file.getOriginalFilename() + "45");
            System.out.println(file.getSize());
            if (FileUtils.upload(file, path, fileName)) {
                productDto.setImage(fileName);
                System.out.println(fileName + "--------------------------------------------------------------------------");
            }
        } else {
            productDto.setImage("fbf18823c6a04177bd97b146d2341388.png");
        }
        productService.save(productDto);
        return "redirect:/manager/catalog";
    }

    @PatchMapping("/manager/product/update/{id}")
    public String proUpdate(@ModelAttribute("product") ProductDto productDto,
                            @Value("${web.upload-path}") String path,
                            @RequestParam ("file") MultipartFile file) {
        System.out.println(productDto);
        if (0 != file.getSize()) {
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            System.out.println(file.getOriginalFilename() + "45");
            System.out.println(file.getSize());
            if (FileUtils.upload(file, path, fileName)) {
                productDto.setImage(fileName);
                System.out.println(fileName + "--------------------------------------------------------------------------");
            }
        } else {
            productDto.setImage("fbf18823c6a04177bd97b146d2341388.png");
        }
        productService.save(productDto);
        return "redirect:/manager/catalog";
    }

    /*@GetMapping("/orders")
    public String getOrders(@ModelAttribute("parameter") Par par,
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
    public String index(@ModelAttribute("parameter") Par par, @ModelAttribute("filter") OrderFilter orderFilter,
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

        //Par par = (Par) session.getAttribute("parameter");

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

    @ModelAttribute("parameter")
    public Par populateName() {
        return Par.builder().build();
    }

    @ModelAttribute("filter")
    public OrderFilter populateFilter() {
        return OrderFilter.builder().build();
    }*/
}