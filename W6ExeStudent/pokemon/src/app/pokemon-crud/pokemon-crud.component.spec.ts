import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonCrudComponent } from './pokemon-crud.component';

describe('PokemonCrudComponent', () => {
  let component: PokemonCrudComponent;
  let fixture: ComponentFixture<PokemonCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PokemonCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokemonCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
