/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { MaTestModule } from '../../../test.module';
import { AnalysisSessionResourceUpdateComponent } from 'app/entities/analysis-session-resource/analysis-session-resource-update.component';
import { AnalysisSessionResourceService } from 'app/entities/analysis-session-resource/analysis-session-resource.service';
import { AnalysisSessionResource } from 'app/shared/model/analysis-session-resource.model';

describe('Component Tests', () => {
    describe('AnalysisSessionResource Management Update Component', () => {
        let comp: AnalysisSessionResourceUpdateComponent;
        let fixture: ComponentFixture<AnalysisSessionResourceUpdateComponent>;
        let service: AnalysisSessionResourceService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [MaTestModule],
                declarations: [AnalysisSessionResourceUpdateComponent]
            })
                .overrideTemplate(AnalysisSessionResourceUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(AnalysisSessionResourceUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(AnalysisSessionResourceService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AnalysisSessionResource(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.analysisSessionResource = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new AnalysisSessionResource();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.analysisSessionResource = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
